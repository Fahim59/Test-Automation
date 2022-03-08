package com.TestNG.FailedTestCases;

import org.testng.*;
import org.testng.annotations.*;

import java.lang.reflect.*;

public class Transformer implements IAnnotationTransformer {

    public void transform(ITestAnnotation annotation, Class testclass, Constructor constructor, Method method){
        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}
