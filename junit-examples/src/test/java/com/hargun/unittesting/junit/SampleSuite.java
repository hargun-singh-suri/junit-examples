/**
 * 
 */
package com.hargun.unittesting.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author hargun.suri
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ PerformanceExampleTest.class, StringHelperParameterizedTest.class })
public class SampleSuite {

}
