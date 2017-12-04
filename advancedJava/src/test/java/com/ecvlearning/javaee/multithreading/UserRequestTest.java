package com.ecvlearning.javaee.multithreading;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserRequestTest {

    @Test
    public void testThread() {
        Runnable userRequest = new UserRequest(true);
        Thread userRequestThread = new Thread(userRequest);
        Thread userRequestThread2 = new Thread(userRequest);
        userRequestThread.start();
        userRequestThread2.start();

        try {
            userRequestThread.join();
            userRequestThread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(2 * 100000000, ((UserRequest) userRequest).getCount());

    }
}
