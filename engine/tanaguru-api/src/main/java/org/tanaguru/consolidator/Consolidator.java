/*
 * Tanaguru - Automated webpage assessment
 * Copyright (C) 2008-2015  Asqatasun.org
 *
 * This file is part of Tanaguru.
 *
 * Tanaguru is free software: you can redistribute it and/or modify
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
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */
package org.tanaguru.consolidator;

import java.util.Collection;
import java.util.List;
import org.tanaguru.entity.audit.ProcessResult;
import org.tanaguru.ruleimplementation.RuleImplementation;
import org.tanaguru.service.ProcessRemarkService;

/**
 * 
 * @author jkowalczyk
 */
public interface Consolidator {

    /**
     *
     * @return
     */
    Collection<ProcessResult> getGrossResultList();

    /**
     *
     * @return
     */
    Collection<ProcessResult> getResult();

    /**
     *
     * @return
     */
    RuleImplementation getRuleImplementation();

    /**
     *
     */
    void run();

    /**
     *
     * @param grossResultList
     */
    void setGrossResultList(List<ProcessResult> grossResultList);

    /**
     * 
     * @param ruleImplementation
     */
    void setRuleImplementation(RuleImplementation ruleImplementation);

    /**
     * 
     * @param processRemarkService
     */
    void setProcessRemarkService(ProcessRemarkService processRemarkService);
}
