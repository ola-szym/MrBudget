//package com.project.budget;
//
//import com.project.budget.Budget;
//import com.project.security.UserRepository;
//import com.project.budget.BudgetRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class BudgetService {
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private BudgetRepository budgetRepository;
//
//    @Autowired
//    private TransactionService transactionService;
//
//    @Autowired
//    private UserRepository accountRepository;
//
//
//    public BudgetService(BudgetRepository budgetRepository, TransactionService transactionService, UserRepository accountRepository)
//    {
//        this.budgetRepository = budgetRepository;
//        this.transactionService = transactionService;
//        this.accountRepository = accountRepository;
//
//        createDefaults();
//    }
//
//    public BudgetRepository getRepository()
//    {
//        return budgetRepository;
//    }
//
//
//    public void deleteBudget(int id)
//    {
//        Budget budgetToDelete = budgetRepository.findById(id);
//        transactionService.deleteTransactionsWithBudget(budgetToDelete);
//        budgetToDelete.setReferringTransactions(new ArrayList<>());
//
//        // select "all accounts" as selected account
//        selectAccount(accountRepository.findAllByType(AccountType.ALL).get(0).getID());
//
//        // set new default if necessary
//        if(budgetToDelete.isDefault())
//        {
//            List<Budget> budgets = budgetRepository.findAllByType(AccountType.CUSTOM);
//            budgets.remove(budgetToDelete);
//            setAsDefaultAccount(budgets.get(0).getID());
//        }
//
//        budgetRepository.delete(ID);
//    }
//
//    @Override
//    public void deleteAll()
//    {
//        deselectAllAccounts();
//        User user = userRepository.findByName("Default");
//        user.setSelectedAccount(null);
//        userRepository.save(user);
//
//        accountRepository.deleteAll();
//    }
//
//    @Override
//    public void createDefaults()
//    {
//        if(accountRepository.findAll().isEmpty())
//        {
//            User placeholder = new User("Placeholder", AccountType.ALL);
//            accountRepository.save(placeholder);
//            LOGGER.debug("Created placeholder account");
//
//            User account =  accountRepository.save(new User(Localization.getString(Strings.ACCOUNT_DEFAULT_NAME), AccountType.CUSTOM));
//            selectAccount(account.getID());
//            setAsDefaultAccount(account.getID());
//            LOGGER.debug("Created default account");
//        }
//
//        User defaultAccount = accountRepository.findByIsDefault(true);
//        if(defaultAccount == null)
//        {
//            User account = accountRepository.findAllByType(AccountType.CUSTOM).get(0);
//            setAsDefaultAccount(account.getID());
//        }
//        setAsDefaultAccount(accountRepository.findByIsDefault(true).getID());
//    }
//
//    private void deselectAllAccounts()
//    {
//        List<User> accounts = accountRepository.findAll();
//        for(User currentAccount : accounts)
//        {
//            currentAccount.setSelected(false);
//            accountRepository.save(currentAccount);
//        }
//    }
//
//    public void selectAccount(int ID)
//    {
//        deselectAllAccounts();
//
//        User accountToSelect = accountRepository.findOne(ID);
//        accountToSelect.setSelected(true);
//        accountRepository.save(accountToSelect);
//
//        User user = userRepository.findByName("Default");
//        if(user != null)
//        {
//            user.setSelectedAccount(accountToSelect);
//            userRepository.save(user);
//        }
//    }
//
//    public void setAsDefaultAccount(int ID)
//    {
//        unsetDefaultForAllAccounts();
//
//        User accountToSelect = accountRepository.findOne(ID);
//        accountToSelect.setDefault(true);
//        accountRepository.save(accountToSelect);
//    }
//
//    private void unsetDefaultForAllAccounts()
//    {
//        List<User> accounts = accountRepository.findAll();
//        for(User currentAccount : accounts)
//        {
//            currentAccount.setDefault(false);
//            accountRepository.save(currentAccount);
//        }
//    }
//}
