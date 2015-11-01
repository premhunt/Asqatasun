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
package org.tanaguru.i18n.entity.factory.reference;

import org.tanaguru.i18n.entity.reference.NomenclatureI18n;
import org.tanaguru.i18n.entity.reference.NomenclatureI18nImpl;

/**
 * 
 * @author jkowalczyk
 */
public class NomenclatureI18nFactoryImpl implements NomenclatureI18nFactory {

    public NomenclatureI18nFactoryImpl() {
        super();
    }

    @Override
    public NomenclatureI18n create() {
        return new NomenclatureI18nImpl();
    }

}