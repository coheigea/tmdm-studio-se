// ============================================================================
//
// Copyright (C) 2006-2019 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package com.amalto.workbench.providers.datamodel.util;
import org.eclipse.xsd.XSDAnnotation;


class SchemaItemRoleSelectorOnReadonly extends SchemaItemRoleSelectorOnNotAll {

    @Override
    protected boolean isRoleValid(String role, XSDAnnotation annotation) {
        return (annotation == null);
    }

}
