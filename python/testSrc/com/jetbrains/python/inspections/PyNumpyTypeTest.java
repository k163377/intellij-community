/*
 * Copyright 2000-2015 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jetbrains.python.inspections;

import com.jetbrains.python.fixtures.PyTestCase;

public class PyNumpyTypeTest extends PyTestCase {
  public static final String TEST_DIRECTORY = "inspections/PyNumpyType/";

  private void doTest() {
    myFixture.configureByFile(TEST_DIRECTORY + getTestName(false) + ".py");
    myFixture.enableInspections(PyTypeCheckerInspection.class);
    myFixture.checkHighlighting(true, false, true);
  }

  public void testNominalType() {
    doTest();
  }

  public void testDtype() {
    doTest();
  }

  public void testEmpty() {
    doTest();
  }

  public void testTranspose() {
    doTest();
  }

  public void testArgSort() {
    doTest();
  }

  public void testVectorize() {
    doTest();
  }

  public void testDefaultValue() {
    doTest();
  }

  public void testDefaultValueKeyword() {
    doTest();
  }

  public void testSort() {
    doTest();
  }

  public void testUFunc() {
    doTest();
  }

  public void testReturnOptional() {
    myFixture.configureByFile(TEST_DIRECTORY + getTestName(false) + ".py");
    myFixture.enableInspections(PyTupleAssignmentBalanceInspection.class);
    myFixture.checkHighlighting(true, false, true);
  }

  public void testReturnTuple() {
    myFixture.configureByFile(TEST_DIRECTORY + getTestName(false) + ".py");
    myFixture.enableInspections(PyTupleAssignmentBalanceInspection.class);
    myFixture.checkHighlighting(true, false, true);
  }

  public void testSlogdet() {
    myFixture.configureByFile(TEST_DIRECTORY + getTestName(false) + ".py");
    myFixture.enableInspections(PyTupleAssignmentBalanceInspection.class);
    myFixture.checkHighlighting(true, false, true);
  }
}
