package test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

import ejercicio2.ConcatenarTest;
import ejercicio5.ComprobacionesTest;
import ejercicios3_4.FechaTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({ConcatenarTest.class, ComprobacionesTest.class, FechaTest.class})
public class AllTests {

}
