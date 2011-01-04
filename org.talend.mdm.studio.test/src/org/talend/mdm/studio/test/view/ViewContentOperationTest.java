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
package org.talend.mdm.studio.test.view;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * ViewContentOperationTest is a SWTBot test class to imitate the process to create a view like Browse_items_Agent.
 * 
 * DOC rhou class global comment. Detailled comment
 * 
 * see bug 0017197.
 * 
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ViewContentOperationTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem viewParentItem;

    private SWTBotTreeItem viewItem;

    private String[] array = new String[] { "Id", "Firstname", "Lastname", "CommissionCode", "StartDate", "TermDate" };

    private String PREFIX = "Browse_items_";

    @Before
    public void runBeforeEveryTest() {
        viewParentItem = serverItem.getNode("View [HEAD]");
        viewParentItem.expand();

        createView();
    }

    private void createView() {
        // Create a new view to test the filter of the xpath.
        viewParentItem.contextMenu("New").click();
        // bot.sleep(1000);
        SWTBotShell newViewShell = bot.shell("New View");
        newViewShell.activate();
        // bot.buttonWithLabel("...").click();
        bot.buttonWithTooltip("Select one Entity").click();
        bot.shell("Select one Entity").activate();

        bot.comboBoxWithLabel("Data Models:").setSelection("CONF");
        bot.tree().select("Conf");
        bot.button("Add").click();
        sleep();
        bot.button("OK").click();
        // setDescription();
        // setElements();
        // bot.activeEditor().save();
        // bot.activeEditor().close();
        // viewItem = viewParentItem.getNode(PREFIX + "Conf");
        // Assert.assertNotNull(viewItem);
        sleep(2);
    }

    @Test
    public void ViewContentTest() {
        setDescriptionTest();
        setViewableElementsTest();
        setSearchableElementsTest();
        setWhereConditionsTest();
        bot.activeEditor().save();
        Assert.assertNotNull(viewParentItem.getNode(PREFIX + "Conf"));
    }

    public void setDescriptionTest() {
        bot.buttonWithTooltip("Set the Descriptions").click();
        bot.shell("Set the Descriptions").activate();
        bot.comboBox().setSelection("English");
        String des = "Conf";
        bot.text().setText(des);
        bot.buttonWithTooltip("Add").click();
        bot.button("OK").click();
    }

    public void setViewableElementsTest() {
        bot.buttonWithTooltip("Add Multiple", 0).click();

        bot.shell("Select Multiple XPaths").activate();
        bot.comboBox().setSelection("Agent");
        sleep();
        SWTBotTreeItem parent = bot.tree().getTreeItem("Agent").expand().getNode("Agent").expand();
        parent.select(array);
        sleep();
        bot.button("Add").click();
        sleep();

        bot.buttonWithTooltip("Add Multiple", 1).click();

    }

    public void setSearchableElementsTest() {
        bot.buttonWithTooltip("Add Multiple", 1).click();
        bot.shell("Select Multiple XPaths").activate();
        bot.comboBox().setSelection("Agent");
        sleep();
        SWTBotTreeItem parent = bot.tree().getTreeItem("Agent").expand().getNode("Agent").expand();
        parent.select(array);
        sleep();
        bot.button("Add").click();
        sleep();

        // bot.buttonWithTooltip("Add Multiple", 1).click();
        // bot.shell("Select Multiple XPaths").activate();
        // bot.comboBox().setSelection("Agent");
        // sleep();
        // bot.tree().select("Agent");
        // sleep();
        // bot.button("Add").click();
        // sleep();
    }

    public void setWhereConditionsTest() {
        bot.buttonWithTooltip("Add Multiple", 1).click();
        bot.shell("Select Multiple XPaths").activate();
        bot.comboBox().setSelection("Agent");
        sleep();
        SWTBotTreeItem parent = bot.tree().getTreeItem("Agent").expand().getNode("Agent").expand();
        parent.select("Status");
        sleep();
        bot.button("Add").click();
        sleep();
        // TODO:add the content

        sleep(2);
    }

    @After
    public void runAfterEveryTest() {
        viewParentItem.getNode(PREFIX + "Conf").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
