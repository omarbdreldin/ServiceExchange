/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_exchange.api_services.bussinesslayer.messagebussiness;

import com.service_exchange.api_services.dao.dto.MessageComplaintDto;
import com.service_exchange.api_services.dao.dto.MessagePrivateDto;
import com.service_exchange.api_services.dao.dto.MessageTransactionDto;
import com.service_exchange.api_services.dao.dto.TransactionChatDto;
import com.service_exchange.entities.Message;
import java.util.List;

/**
 *
 * @author esraa
 */

public interface MessageServiceInterface {
    public MessagePrivateDto sendPrivateMessage(Integer senderId,Integer recieverId,Message message);
    public List <MessagePrivateDto>getAllPrivateChatMessages(Integer user1Id, Integer user2Id, Integer pageNum);
    
    public MessageComplaintDto userSendComplaintMessage(Integer senderId, Integer ComplaintId, Message message);
    public MessageComplaintDto adminSendComplaintMessage(Integer ComplaintId,Message message);
    public List <MessageComplaintDto>getAllComplaintMessages(Integer complaintId,Integer senderId,Integer pageNum);
  
    public MessageTransactionDto sendTransactionMessage(Integer senderId , Integer recieverId, Message message, Integer TransactionId);
    public List <MessageTransactionDto>getAllTransactionMessages(Integer transactionId,Integer senderId,Integer pageNum);

    public List<TransactionChatDto>getAllUserTransactionChats(Integer userId,Integer pageNum);
   
}
