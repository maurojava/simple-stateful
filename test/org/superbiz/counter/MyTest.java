/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.superbiz.counter;

import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.inject.Named;
import javax.naming.Context;
import javax.naming.NamingException;
import static junit.framework.TestCase.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mauro
 */

public class MyTest {

    public static EJBContainer container;
    public Context context;

    public MyTest() {
      // this.context = container.getContext();
    }
    @Inject
 //   @EJB
    Counter counterA;

    @BeforeClass
    public static void setUpClass() {
        container = EJBContainer.createEJBContainer();
    }

    @AfterClass
    public static void tearDownClass() {
   container.close(); }

    @Before
    public void setUp() throws NamingException {
        context = container.getContext();
        context.bind("inject", this);
    }

    @After
    public void tearDown() {
    }
    @Test
     public void test() throws Exception {

       // final Context context = EJBContainer.createEJBContainer().getContext();

     //   Counter counterA = (Counter) context.lookup("java:global/WEB-INF/Counter");
   //     Counter counterA = (Counter) context.lookup("global/simple-stateful/Counter");
        //  Counter counterA = (Counter) context.lookup("java:global/simple-stateful/Counter");
        //    Counter counterA = (Counter) context.lookup("java:global/WEB-INF/Counter!org.superbiz.counter.Counter");
//java:global/WEB-INF/Counter
        assertEquals(0, counterA.count());
        assertEquals(0, counterA.reset());
        assertEquals(1, counterA.increment());
        assertEquals(2, counterA.increment());
        assertEquals(0, counterA.reset());

        counterA.increment();
        counterA.increment();
        counterA.increment();
        counterA.increment();

        assertEquals(4, counterA.count());

        // Get a new counter
     //   Counter counterB = (Counter) context.lookup("java:global/simple-stateful/Counter");

        // The new bean instance starts out at 0
       
        //assertEquals(0, counterB.count());
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
