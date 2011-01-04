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
package org.talend.mdm.studio.test.view.item;

import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotMenu;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.talend.mdm.studio.test.TalendSWTBotForMDM;

/**
 * DOC rhou class global comment. Detailled comment
 */
@RunWith(SWTBotJunit4ClassRunner.class)
public class ViewDuplicateTest extends TalendSWTBotForMDM {

    private SWTBotTreeItem viewParentItem;

    private SWTBotTreeItem viewItem;

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
        setDescription();
        setElements();
        bot.activeEditor().save();
        bot.activeEditor().close();
        viewItem = viewParentItem.getNode(PREFIX + "Conf");
        Assert.assertNotNull(viewItem);
        sleep(2);
    }

    private void setElements() {
        bot.buttonWithTooltip("Add", 0).click();
        bot.buttonWithTooltip("Add", 1).click();

    }

    private void setDescription() {
        bot.buttonWithTooltip("Set the Descriptions").click();
        bot.shell("Set the Descriptions").activate();
        bot.comboBox().setSelection("English");
        String des = "Conf";
        bot.text().setText(des);
        bot.buttonWithTooltip("Add").click();
        bot.button("OK").click();
    }

    @Test
    public void viewDuplicateTest() {
        SWTBotMenu duplicateMenu = viewItem.contextMenu("Duplicate");
        duplicateMenu.click();
        SWTBotShell shell = bot.shell("Pasting instance Testview");
        shell.activate();
        bot.text("CopyOf" + PREFIX + "Conf").setText(PREFIX + "Conf" + "DuplicateView");
        sleep();
        bot.button("OK").click();
        SWTBotTreeItem duplicateNode = viewParentItem.getNode(PREFIX + "Conf" + "DuplicateView");
        Assert.assertNotNull(duplicateNode);
        sleep(2);

    }

    @After
    public void runAfterEveryTest() {

        viewParentItem.getNode(PREFIX + "Conf" + "DuplicateView").contextMenu("Delete").click();
        sleep();
        bot.button("OK").click();
        sleep();
    }

}
