package com.myspring.controllers;


import com.myspring.beans.UserBean;
import com.myspring.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserBean userBean;

    @RequestMapping("/default")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return admin();
        }
        return managerPage();
    }

    @RequestMapping(value = {"/login", "/"}, method= RequestMethod.GET)
    public ModelAndView enter() {
        ModelAndView mw = new ModelAndView("login");
        return mw;
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public ModelAndView accessDeniedPage() {
        ModelAndView mw = new ModelAndView("403");
        return mw;
    }

    @RequestMapping(value = "/managerPage", method = RequestMethod.GET)
    public ModelAndView managerPage() {
        ModelAndView mw = new ModelAndView("managerPage");
        return mw;
    }

    @RequestMapping(value = "/addAccountPage", method = RequestMethod.GET)
    public ModelAndView addAccountPage() {
        ModelAndView mw = new ModelAndView("addAccount");
        List<Currencies> cur = userBean.getCurrencies();
        mw.addObject("currencies", cur);
        return mw;
    }

    @RequestMapping(value = {"/addManagerPage"}, method= RequestMethod.GET)
    public ModelAndView addManagerPage() {
        ModelAndView mw = new ModelAndView("addManager");
        return mw;
    }

    @RequestMapping(value = {"/currencyPage"}, method= RequestMethod.GET)
    public ModelAndView currencyPage() {
        ModelAndView mw = new ModelAndView("currency");
        List<CurrencyExchange> list = userBean.getCurrencyExList();
        mw.addObject("curList", list);
        return mw;
    }


    @RequestMapping(value = {"/transactionListPage"}, method= RequestMethod.GET)
    public ModelAndView transactionListPage() {
        ModelAndView mw = new ModelAndView("transactionList");
        List<TransactionHistories> transactionList = userBean.getTransactionList();
        mw.addObject("transactionList", transactionList);
        mw.addObject("role", 1);
        return mw;
    }

    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView profile() {
        Users user = getUserData();
        ModelAndView mw = new ModelAndView("profile");
        mw.addObject("user", user);
        return mw;
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public ModelAndView admin() {
        ModelAndView mw = new ModelAndView("adminPage");
        List<BankTotalBalance> totalBalance = userBean.getTotalBalance();
        mw.addObject("balance", totalBalance);
        return mw;
    }

    @RequestMapping(value = "/addManager", method = RequestMethod.POST)
    public ModelAndView addManager(
            @RequestParam(name = "login") String login,
            @RequestParam(name = "password") String password,
            @RequestParam(name = "fullName") String fullName) {
        Roles role = new Roles();
        role.setId(2);
        String sha1 = "";
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
            digest.update(password.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        } catch (Exception e){
            e.printStackTrace();
        }
        Users user = new Users(login, sha1, fullName, role);
        userBean.addManager(user);
        return admin();
    }

    @RequestMapping(value = "/editCurrencies", method = RequestMethod.POST)
    public ModelAndView editCurrencies(
            @RequestParam(name = "buy") String buy,
            @RequestParam(name = "sale") String sale,
            @RequestParam(name = "id") String id) {
        Currencies tempCurrency = new Currencies();
        tempCurrency.setId(Integer.parseInt(id) + 1);
        CurrencyExchange tempCurrencyExchange = new CurrencyExchange(tempCurrency, Double.valueOf(buy), Double.valueOf(sale), String.valueOf(new Date()));
        tempCurrencyExchange.setId(Integer.parseInt(id));
        userBean.editCurrencyEx(tempCurrencyExchange);
        return currencyPage();
    }

    @RequestMapping(value = "/addAccount", method = RequestMethod.POST)
    public ModelAndView addAccount(
            @RequestParam(name = "fname") String fname,
            @RequestParam(name = "lname") String lname,
            @RequestParam(name = "bdate") String bdate,
            @RequestParam(name = "iin") String iin,
            @RequestParam(name = "currency") String currencyId,
            @RequestParam(name = "amount") String amount) {
        Currencies tempCurrecny = new Currencies();
        tempCurrecny.setId(Integer.parseInt(currencyId));
        Accounts account = new Accounts(fname, lname, bdate, iin, tempCurrecny, Double.valueOf(amount));
        userBean.addAccount(account);
        return managerPage();
    }

    @RequestMapping(value = {"/accountsListPage"}, method= RequestMethod.GET)
    public ModelAndView accountsListPage() {
        ModelAndView mw = new ModelAndView("AccountsList");
        List<Accounts> accountsList = userBean.getAccountsList();
        List<Operations> operationsList = userBean.getOperationsList();
        mw.addObject("accountsList", accountsList);
        mw.addObject("operationsList", operationsList);
        return mw;
    }

    @RequestMapping(value = {"/seeAccountHistory"}, method= RequestMethod.GET)
    public ModelAndView accountsHistory(
            @RequestParam(name = "id") String accountId) {
        ModelAndView mw = new ModelAndView("transactionList");
        List<TransactionHistories> transactionList = userBean.getAccountTransactionList(Integer.parseInt(accountId));
        mw.addObject("transactionList", transactionList);
        mw.addObject("role", 2);
        return mw;
    }

    @RequestMapping(value = {"/seeManagerHistory"}, method= RequestMethod.GET)
    public ModelAndView managerHistory() {
        ModelAndView mw = new ModelAndView("transactionList");
        int managerId = getUserData().getId();
        List<TransactionHistories> transactionList = userBean.getManagerTransactionList(managerId);
        mw.addObject("transactionList", transactionList);
        mw.addObject("role", 2);

        return mw;
    }

    @RequestMapping(value = {"/userOperation"}, method= RequestMethod.POST)
    public ModelAndView userOperation(
            @RequestParam(name = "id") String accountId,
            @RequestParam(name = "operation") String operationId) {
        ModelAndView mw = null;
        int opId = Integer.parseInt(operationId);
        int accId = Integer.parseInt(accountId);
        if (opId == 1){
            mw = new ModelAndView("moneyTransfer");
            List<Accounts> accountsList = userBean.getAccountsList();
            Accounts account = userBean.getAccountInformationById(accId);
            mw.addObject("accountsList", accountsList);
            mw.addObject("account", account);
        } else if (opId == 2){
            mw = new ModelAndView("exchange");
            Accounts account = userBean.getAccountInformationById(accId);
            List<Currencies> list = userBean.getCurrencies();
            mw.addObject("currencies", list);
            mw.addObject("account", account);
        } else if (opId == 3){
            mw = new ModelAndView("debet");
            Accounts account = userBean.getAccountInformationById(accId);
            mw.addObject("account", account);
        } else if (opId == 4){
            mw = new ModelAndView("credit");
            Accounts account = userBean.getAccountInformationById(accId);
            mw.addObject("account", account);
        }
        return mw;
    }

    @RequestMapping(value = {"/debetOperation"}, method= RequestMethod.POST)
    public ModelAndView debet(
            @RequestParam(name = "id") String accountId,
            @RequestParam(name = "value") String value) {
        userBean.debet(getUserData(), Integer.parseInt(accountId), Double.valueOf(value));
        return accountsListPage();
    }

    @RequestMapping(value = {"/creditOperation"}, method= RequestMethod.POST)
    public ModelAndView credit(
            @RequestParam(name = "id") String accountId,
            @RequestParam(name = "value") String value) {
        userBean.credit(getUserData(), Integer.parseInt(accountId), Double.valueOf(value));
        return accountsListPage();
    }

    @RequestMapping(value = {"/transferOperation"}, method= RequestMethod.POST)
    public ModelAndView credit(
            @RequestParam(name = "id") String fromId,
            @RequestParam(name = "value") String value,
            @RequestParam(name = "targetIin") String targetIin) {
        List<Accounts> accounts = userBean.getAccountsList();
        for (int i=0; i<accounts.size(); i++) {
            if (targetIin.equals(accounts.get(i).getIin_number())) {
                userBean.transfer(getUserData(), Integer.parseInt(fromId), Double.valueOf(value), targetIin);
                return accountsListPage();
            }
        }
        ModelAndView mw = new ModelAndView("moneyTransfer");
        List<Accounts> accountsList = userBean.getAccountsList();
        Accounts account = userBean.getAccountInformationById(Integer.parseInt(fromId));
        String error = "Incorrect IIN";
        mw.addObject("accountsList", accountsList);
        mw.addObject("account", account);
        mw.addObject("error", error);
        return mw;
    }

    @RequestMapping(value = {"/exchangeOperation"}, method= RequestMethod.POST)
    public ModelAndView exchangeOperation(
            @RequestParam(name = "id") String fromId,
            @RequestParam(name = "currentCurrencyId") String curId,
            @RequestParam(name = "newCurrencyId") String newCurId) {
        userBean.exchange(getUserData(), Integer.parseInt(fromId), Integer.parseInt(curId), Integer.parseInt(newCurId));
        return accountsListPage();
    }

    public Users getUserData() {
        Users user = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails ud = (UserDetails) authentication.getPrincipal();
            user = userBean.getUser(ud.getUsername());
        }
        return user;
    }
}