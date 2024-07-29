package com.useractivitymanagement.config;

import com.useractivitymanagement.entity.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {

    @Override
    public Customer process(Customer item) throws Exception {

        // logic

        return item;
    }

}
