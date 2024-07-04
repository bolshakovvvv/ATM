package com.example.demo.model;

import lombok.Data;

@Data
public class SendMoneyRequest {

    int senderNumber;
    int receiverNumber;
    int amount;

}
