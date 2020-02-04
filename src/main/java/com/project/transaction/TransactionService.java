//package com.project.services;
//
//import com.project.budget.Budget;
//import com.project.transaction.Transaction;
//import com.project.category.CategoryRepository;
//import com.project.transaction.TransactionRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class TransactionService{
//
//    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    TransactionRepository transactionRepository;
//
//    @Autowired
//    CategoryRepository categoryRepository;
//
//
//    public TransactionService(TransactionRepository transactionRepository, CategoryRepository categoryRepository)
//    {
//        this.transactionRepository = transactionRepository;
//        this.categoryRepository = categoryRepository;
//    }
//
//    public TransactionRepository getRepository()
//    {
//        return transactionRepository;
//    }
//
//    public void deleteTransactionsWithBudget(Budget budget) {
//        for(Transaction referringTransaction : budget.getReferringTransactions())
//        {
//            deleteTransactionInRepo(referringTransaction.getID());
//        }
//
//        for(Transaction referringTransaction : transactionRepository.findAllByTransferBudget(budget))
//        {
//            deleteTransactionInRepo(referringTransaction.getID());
//        }
//    }
//
//    private void deleteTransactionInRepo(Integer ID)
//    {
//        Transaction transactionToDelete = transactionRepository.findOne(ID);
//        if(transactionToDelete == null)
//        {
//            LOGGER.debug("Skipping already deleted transaction with ID: " + ID);
//            return;
//        }
//
//        // handle repeating transactions
//        if(transactionToDelete.getRepeatingOption() == null)
//        {
//            transactionRepository.delete(ID);
//        }
//        else
//        {
//            repeatingOptionRepository.delete(transactionToDelete.getRepeatingOption().getID());
//        }
//    }
//
//}
