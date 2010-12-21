// ============================================================================
//
// Copyright (C) 2006-2010 Talend Inc. - www.talend.com
//
// This source code is available under agreement available at
// %InstallDIR%\features\org.talend.rcp.branding.%PRODUCTNAME%\%PRODUCTNAME%license.txt
//
// You should have received a copy of the agreement
// along with this program; if not, write to Talend SA
// 9 rue Pages 92150 Suresnes, France
//
// ============================================================================
package org.talend.mdm.studio.test.role;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * roleTest is a superclass of the test classes for testing the functions of Data Container.
 * 
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class RoleParentOperationTest extends TalendSWTBotForMDM {

    protected static SWTBotTreeItem roleParentItem;

    @Before
    public void runBeforeEveryTest() {
        roleParentItem = serverItem.getNode("Role [HEAD]");
        roleParentItem.expand();
    }

    @Test
    public void roleCreationTest() {
        roleParentItem.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell shell = bot.shell("New Role");
        shell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the Role:");
        text.setText("TestRole");
        sleep();
        bot.buttonWithTooltip("Add").click();
        sleep();
        bot.button(IDialogConstants.NEXT_LABEL).click();
        sleep();

        bot.comboBoxWithLabel("Administrator").selection();
        bot.button(IDialogConstants.FINISH_LABEL).click();
        bot.activeEditor().save();
        bot.activeEditor().close();

        Assert.assertNotNull(roleParentItem.getNode("TestRole"));
        sleep(2);
    }

    @Test
    public void roleCategoryCreationTest() {
        roleParentItem.contextMenu("New Category").click();
        // bot.sleep(1000);
        SWTBotShell newCategoryShell = bot.shell("New Category");
        newCategoryShell.activate();
        SWTBotText text = bot.textWithLabel("Enter a name for the New Category");
        text.setText("TestRoleCategory");
        bot.button("OK").click();
        Assert.assertNotNull(roleParentItem.getNode("TestRoleCategory"));
        sleep(2);
    }

    @Test
    public void roleBrowseRevisionTest() {
        roleParentItem.contextMenu("Browse Revision").click();
        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        roleParentItem.getNode("TestRole").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();

        roleParentItem.getNode("TestRoleCategory").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }
}
