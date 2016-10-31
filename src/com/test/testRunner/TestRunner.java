/**
 * Created by rajivbhati on 10/30/16.
 * @description: Test Runner class to run Testcases
 */

package com.test.testRunner;
import com.test.testCases.WhenAUserSearchesOnGoogle;
import org.junit.runner.notification.Failure;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class TestRunner {
    public static void main(String[] args) {
        ResourcePath dp = ResourcePath.getInstance();
        dp.setPath((args[0]).toString());
        Result result = JUnitCore.runClasses(WhenAUserSearchesOnGoogle.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
    }
}