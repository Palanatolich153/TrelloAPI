package log;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.ObjectMapperConfig;
import com.jayway.restassured.config.RestAssuredConfig;
import com.jayway.restassured.filter.log.RequestLoggingFilter;
import com.jayway.restassured.filter.log.ResponseLoggingFilter;
import com.jayway.restassured.internal.mapper.ObjectMapperType;
import lombok.extern.log4j.Log4j;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

@Log4j
public class ListenerTest implements ITestListener {

    @Override
    public void onStart(ITestContext context) {

        RestAssured.config = RestAssuredConfig.config().objectMapperConfig(new ObjectMapperConfig(ObjectMapperType.GSON));
        //RestAssured.filters((Filter) new AllureRestAssured());

        if (log.isDebugEnabled()) {
            RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
        }
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

    }

    /**
     * When Test case get failed, this method is called.
     */
    @Override
    public void onTestFailure(ITestResult result) {

        log.info(result.getMethod().getMethodName() + " FAILED");
    }

    /**
     * When Test case get Skipped, this method is called.
     */
    @Override
    public void onTestSkipped(ITestResult result) {

        log.info(result.getMethod().getMethodName() + " SKIPPED");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    /**
     * When Test case get Started, this method is called.
     */
    @Override
    public void onTestStart(ITestResult result) {

        log.info(result.getMethod().getMethodName() + " STARTED");
    }

    /**
     * When Test case get passed, this method is called.
     */
    @Override
    public void onTestSuccess(ITestResult result) {

        log.info(result.getMethod().getMethodName() + " PASSED");
    }
}