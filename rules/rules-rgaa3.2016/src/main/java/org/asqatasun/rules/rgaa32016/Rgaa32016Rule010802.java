/*
 * Asqatasun - Automated webpage assessment
 * Copyright (C) 2008-2019  Asqatasun.org
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
 * Contact us by mail: asqatasun AT asqatasun DOT org
 */

package org.asqatasun.rules.rgaa32016;

import org.apache.commons.lang3.tuple.ImmutablePair;
import static org.asqatasun.entity.audit.TestSolution.NEED_MORE_INFO;
import static org.asqatasun.entity.audit.TestSolution.NOT_APPLICABLE;
import org.asqatasun.ruleimplementation.AbstractMarkerPageRuleImplementation;
import org.asqatasun.rules.elementchecker.element.ElementPresenceChecker;
import org.asqatasun.rules.elementselector.ImageElementSelector;
import static org.asqatasun.rules.keystore.AttributeStore.SRC_ATTR;
import static org.asqatasun.rules.keystore.CssLikeQueryStore.FORM_BUTTON_CSS_LIKE_QUERY;
import static org.asqatasun.rules.keystore.MarkerStore.DECORATIVE_IMAGE_MARKER;
import static org.asqatasun.rules.keystore.MarkerStore.INFORMATIVE_IMAGE_MARKER;
import static org.asqatasun.rules.keystore.RemarkMessageStore.CHECK_NATURE_OF_IMAGE_AND_TEXT_STYLED_PRESENCE_MSG;
import static org.asqatasun.rules.keystore.RemarkMessageStore.CHECK_TEXT_STYLED_PRESENCE_OF_INFORMATIVE_IMG_MSG;

/**
 * Implementation of the rule 1.8.2 of the referential RGAA 3.2016
 * <br/>
 * For more details about the implementation, refer to <a href="http://doc.asqatasun.org/en/90_Rules/rgaa3.2016/01.Images/Rule-1-8-2.html">the rule 1.8.2 design page.</a>
 * @see <a href="http://references.modernisation.gouv.fr/rgaa-accessibilite/2016/criteres.html#test-1-8-2">1.8.2 rule specification</a>
 *
 */
public class Rgaa32016Rule010802  extends AbstractMarkerPageRuleImplementation {

    /**
     * Default constructor
     */
    public Rgaa32016Rule010802  () {
        super(
                new ImageElementSelector(FORM_BUTTON_CSS_LIKE_QUERY),
                INFORMATIVE_IMAGE_MARKER,
                DECORATIVE_IMAGE_MARKER,
                new ElementPresenceChecker(
                        new ImmutablePair(NEED_MORE_INFO, CHECK_TEXT_STYLED_PRESENCE_OF_INFORMATIVE_IMG_MSG),
                        new ImmutablePair(NOT_APPLICABLE, ""),
                        // evidence elements
                        SRC_ATTR
                ),
                new ElementPresenceChecker(
                        new ImmutablePair(NEED_MORE_INFO, CHECK_NATURE_OF_IMAGE_AND_TEXT_STYLED_PRESENCE_MSG),
                        new ImmutablePair(NOT_APPLICABLE, ""),
                        // evidence elements
                        SRC_ATTR
                )
            );
    }

}
