/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2013  Open-S Company
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Contact us by mail: open-s AT open-s DOT com
 */
package org.opens.tanaguru.rules.accessiweb22;

import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.commons.lang3.StringUtils;
import org.opens.tanaguru.entity.audit.*;
import org.opens.tanaguru.rules.accessiweb22.test.Aw22RuleImplementationTestCase;
import org.opens.tanaguru.rules.keystore.AttributeStore;
import org.opens.tanaguru.rules.keystore.HtmlElementStore;
import org.opens.tanaguru.rules.keystore.RemarkMessageStore;

/**
 * Unit test class for the implementation of the rule 13.6.3 of the referential Accessiweb 2.2.
 *
 * @author jkowalczyk
 */
public class Aw22Rule13063Test extends Aw22RuleImplementationTestCase {

    /**
     * Default constructor
     */
    public Aw22Rule13063Test (String testName){
        super(testName);
    }

    @Override
    protected void setUpRuleImplementationClassName() {
        setRuleImplementationClassName(
                "org.opens.tanaguru.rules.accessiweb22.Aw22Rule13063");
    }

    @Override
    protected void setUpWebResourceMap() {
        getWebResourceMap().put("AW22.Test.13.6.3-3NMI-01",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-3NMI-01.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-3NMI-02",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-3NMI-02.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-3NMI-03",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-3NMI-03.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-3NMI-04",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-3NMI-04.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-3NMI-05",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-3NMI-05.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-3NMI-06",
                getWebResourceFactory().createPage(
                getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-3NMI-06.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-4NA-01",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-4NA-01.html"));
        getWebResourceMap().put("AW22.Test.13.6.3-4NA-02",
              getWebResourceFactory().createPage(
              getTestcasesFilePath() + "AW22/Aw22Rule13063/AW22.Test.13.6.3-4NA-02.html"));
    }

    @Override
    protected void setProcess() {
        //----------------------------------------------------------------------
        //------------------------------3NMI-01---------------------------------
        //----------------------------------------------------------------------
        ProcessResult processResult = processPageTest("AW22.Test.13.6.3-3NMI-01");
        // check number of elements in the page
        assertEquals(1, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        SourceCodeRemark sourceCodeRemark = ((SourceCodeRemark)((LinkedHashSet)processResult.getRemarkSet()).iterator().next());
        assertEquals(TestSolution.NEED_MORE_INFO, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.DOWNLOADABLE_FILE_DETECTED_CHECK_LANG_MSG, 
                     sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.A_ELEMENT, sourceCodeRemark.getTarget());
        // check number of evidence elements and their value
        assertEquals(2, sourceCodeRemark.getElementList().size());
        Iterator<EvidenceElement> iter = sourceCodeRemark.getElementList().iterator();
        EvidenceElement ee = iter.next();
        assertTrue(StringUtils.contains(ee.getValue(), "my-link.odt"));
        assertEquals(AttributeStore.HREF_ATTR, ee.getEvidence().getCode());
        ee = iter.next();
        assertEquals("attribute-absent",ee.getValue());
        assertEquals(AttributeStore.TITLE_ATTR, ee.getEvidence().getCode());


        //----------------------------------------------------------------------
        //------------------------------3NMI-02---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-3NMI-02");
        // check number of elements in the page
        assertEquals(1, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        ProcessRemark processRemark = processResult.getRemarkSet().iterator().next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(getMessageKey(RemarkMessageStore.CHECK_DOWNLOADABLE_DOCUMENT_FROM_FORM_MSG), 
                     processRemark.getMessageCode());
        // check number of evidence elements and their value
        assertNull(processRemark.getElementList());
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-03---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-3NMI-03");
        // check number of elements in the page
        assertEquals(1, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        processRemark = processResult.getRemarkSet().iterator().next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(getMessageKey(RemarkMessageStore.CHECK_MANUALLY_LINK_WITHOUT_EXT_MSG), 
                     processRemark.getMessageCode());
        // check number of evidence elements and their value
        assertNull(processRemark.getElementList());
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-04---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-3NMI-04");
        // check number of elements in the page
        assertEquals(2, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        processRemark = processResult.getRemarkSet().iterator().next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(getMessageKey(RemarkMessageStore.CHECK_MANUALLY_LINK_WITHOUT_EXT_MSG), 
                     processRemark.getMessageCode());
        // check number of evidence elements and their value
        assertNull(processRemark.getElementList());
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-05---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-3NMI-05");
        // check number of elements in the page
        assertEquals(1, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        sourceCodeRemark = ((SourceCodeRemark)((LinkedHashSet)processResult.getRemarkSet()).iterator().next());
        assertEquals(TestSolution.NEED_MORE_INFO, sourceCodeRemark.getIssue());
        assertEquals(RemarkMessageStore.DOWNLOADABLE_FILE_DETECTED_CHECK_LANG_MSG, sourceCodeRemark.getMessageCode());
        assertEquals(HtmlElementStore.A_ELEMENT, sourceCodeRemark.getTarget());
        // check number of evidence elements and their value
        assertEquals(2, sourceCodeRemark.getElementList().size());
        iter = sourceCodeRemark.getElementList().iterator();
        ee = iter.next();
        assertTrue(StringUtils.contains(ee.getValue(), "my-link.xyz"));
        assertEquals(AttributeStore.HREF_ATTR, ee.getEvidence().getCode());
        ee = iter.next();
        assertEquals("attribute-absent",ee.getValue());
        assertEquals(AttributeStore.TITLE_ATTR, ee.getEvidence().getCode());
        
        
        //----------------------------------------------------------------------
        //------------------------------3NMI-06---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-3NMI-06");
        // check number of elements in the page
        assertEquals(1, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NEED_MORE_INFO, processResult.getValue());
        // check number of remarks and their value
        assertEquals(1, processResult.getRemarkSet().size());
        processRemark = processResult.getRemarkSet().iterator().next();
        assertEquals(TestSolution.NEED_MORE_INFO, processRemark.getIssue());
        assertEquals(getMessageKey(RemarkMessageStore.CHECK_MANUALLY_LINK_WITHOUT_EXT_MSG), 
                     processRemark.getMessageCode());
        // check number of evidence elements and their value
        assertNull(processRemark.getElementList());
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA--01---------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-4NA-01");
        // check number of elements in the page
        assertEquals(0, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());
        
        
        //----------------------------------------------------------------------
        //------------------------------4NA-02----------------------------------
        //----------------------------------------------------------------------
        processResult = processPageTest("AW22.Test.13.6.3-4NA-02");
        // check number of elements in the page
        assertEquals(26, processResult.getElementCounter());
        // check test result
        assertEquals(TestSolution.NOT_APPLICABLE, processResult.getValue());
        // check number of remarks and their value
        assertNull(processResult.getRemarkSet());
    }

    @Override
    protected void setConsolidate() {
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("AW22.Test.13.6.3-3NMI-01").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("AW22.Test.13.6.3-3NMI-02").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("AW22.Test.13.6.3-3NMI-03").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("AW22.Test.13.6.3-3NMI-04").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("AW22.Test.13.6.3-3NMI-05").getValue());
        assertEquals(TestSolution.NEED_MORE_INFO,
                consolidate("AW22.Test.13.6.3-3NMI-06").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("AW22.Test.13.6.3-4NA-01").getValue());
        assertEquals(TestSolution.NOT_APPLICABLE,
                consolidate("AW22.Test.13.6.3-4NA-02").getValue());
    }

    /**
     * 
     * @param msg
     * @return the message suffixed with the test key identifier
     */
    private String getMessageKey(String msg) {
        StringBuilder strb = new StringBuilder(msg);
        strb.append("_");
        strb.append(getName());
        return strb.toString();
    }
    
}