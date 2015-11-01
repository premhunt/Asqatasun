/*
 * Asqatasun - Automated webpage assessment
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
package org.tanaguru.i18n.entity.service.reference;

import org.tanaguru.entity.reference.Reference;
import org.tanaguru.i18n.entity.reference.ReferenceI18n;
import org.tanaguru.i18n.entity.service.AbstractGenericI18nService;
import org.tanaguru.sdk.entity.i18n.InternationalizedEntity;

/**
 * 
 * @author jkowalczyk
 */
public class ReferenceI18nServiceImpl extends AbstractGenericI18nService<Reference, Long> implements
        ReferenceI18nService {

    public ReferenceI18nServiceImpl() {
        super();
    }

    @Override
    protected void mergeI18nContent(Reference entity,
            InternationalizedEntity<? extends Reference> i18nContent) {
        entity.setDescription(((ReferenceI18n) i18nContent).getDescription());
        entity.setLabel(((ReferenceI18n) i18nContent).getLabel());
    }

}