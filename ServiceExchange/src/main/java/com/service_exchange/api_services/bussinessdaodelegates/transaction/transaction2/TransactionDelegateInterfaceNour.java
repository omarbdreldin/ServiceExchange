package com.service_exchange.api_services.bussinessdaodelegates.transaction.transaction2;

import com.service_exchange.entities.Service;
import com.service_exchange.entities.TransactionInfo;
import com.service_exchange.entities.UserTable;

public interface TransactionDelegateInterfaceNour {

    UserTable checkIfUserExists(Integer userId);

    Service checkIfServiceExists(Integer serviceId);

    boolean completeTransaction(TransactionInfo transactionInfo);

    boolean approveCompletedTransaction(TransactionInfo transactionInfo);

    boolean rejectCompletedTransaction(TransactionInfo transactionInfo);

}
