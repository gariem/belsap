package com.myorg;

import com.myorg.model.BankAccount;
import com.myorg.model.Task;
import com.myorg.repository.BankAccountRepository;
import com.myorg.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Override
    public void run(String... args) {

        for (int i = 0; i < 5; i++) {
            Task task = new Task();
            task.setTaskId(i);
            task.setDescription("Generated task " + i);
            task.setAssignee("N/A");
            task.setCompleted(false);
            taskRepository.save(task);
        }

        for (int i = 1; i <= 6; i++) {
            BankAccount bankAccount1 = new BankAccount();
            bankAccount1.setAccountId(1000 * i + 1);
            bankAccount1.setBalance(new BigDecimal(761));
            bankAccount1.setAccountName("Payday G" + i);

            BankAccount bankAccount2 = new BankAccount();
            bankAccount2.setAccountId(1000 * i + 2);
            bankAccount2.setBalance(new BigDecimal(543));
            bankAccount2.setAccountName("Savings G" + i);

            bankAccountRepository.save(bankAccount1);
            bankAccountRepository.save(bankAccount2);
        }
    }
}
