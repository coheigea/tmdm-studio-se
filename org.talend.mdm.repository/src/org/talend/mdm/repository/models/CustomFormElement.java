// ============================================================================
//
// Copyright (C) 2006-2011 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.repository.models;

import java.util.ArrayList;
import java.util.List;

/**
 * DOC hbhong class global comment. Detailled comment
 */
public class CustomFormElement {

    /**
     * 
     */
    private static final String DIVIDE = "/"; //$NON-NLS-1$

    private List<CustomFormElement> children;

    private String name;

    private CustomFormElement parent;

    private String type;

    private String xpath;

    private boolean canMove = true;

    public CustomFormElement(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public List<CustomFormElement> getChildren() {
        return this.children;
    }

    public String getName() {
        return this.name;
    }

    public CustomFormElement getParent() {
        return this.parent;
    }

    public String getType() {
        return this.type;
    }

    public String getXpath() {
        if (xpath == null) {
            if (parent == null) {
                xpath = DIVIDE + name;
            } else {
                String parentPath = parent.getXpath();
                if (parentPath.length() > 0) {
                    xpath = parentPath + DIVIDE + name;
                } else {
                    xpath = name;
                }
            }

        }

        return this.xpath;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParent(CustomFormElement parent) {
        this.parent = parent;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public void addChild(CustomFormElement child) {
        if (children == null) {
            children = new ArrayList<CustomFormElement>();
        }
        children.add(child);
        child.setParent(this);
    }

    public String toString() {
        return "Name=" + name + "  canMove=" + canMove + "  type=" + type + "  XPath=" + getXpath(); //$NON-NLS-1$//$NON-NLS-2$//$NON-NLS-3$
    }
}
