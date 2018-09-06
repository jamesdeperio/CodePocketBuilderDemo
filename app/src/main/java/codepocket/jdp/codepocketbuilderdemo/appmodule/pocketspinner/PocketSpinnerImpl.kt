/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.pocketspinner

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.Item

class PocketSpinnerImpl(
        private val viewMethod: HasPocketSpinnerContract.ViewMethod) : HasPocketSpinnerContract.Presenter {
    private val itemList:MutableList<Item> = ArrayList<Item>().apply {
        add(Item(id = "1",itemName = "Dog", itemDesc = "fluffy, hairy"))
        add(Item(id = "2",itemName = "Cat", itemDesc = "red eyes"))
        add(Item(id = "3",itemName = "Bird", itemDesc = "parrot"))
    }

    override fun loadSpinner1Item() {
        ('A' until 'Z').forEach { viewMethod.addItemToSpinner1(it.toString()) }
    }

    override fun loadSpinner2Item() {
        itemList.forEach { viewMethod.addItemToSpinner2(it) }
    }


}