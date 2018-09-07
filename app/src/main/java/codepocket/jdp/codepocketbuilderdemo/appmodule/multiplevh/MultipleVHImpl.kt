/**
 * @version codepocket template builder v1.0
 * @author github.com/jamesdeperio
 **/
package codepocket.jdp.codepocketbuilderdemo.appmodule.multiplevh

import codepocket.jdp.codepocketbuilderdemo.global.model.obj.multiplevh.*
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MultipleVHImpl(
        private val viewMethod: HasMultipleVHContract.ViewMethod,
        private val adapter: HasMultipleVHContract.Adapter
) : HasMultipleVHContract.Presenter {
    val dataList:MutableList<Any> = ArrayList<Any>().apply {
        this.add(Header(title = "This is an example of Multiple View Holder."))
        this.add(SubTitle(title = "First Group (INFO)",groupID = 0))
        this.add(ContentText(id = 0,desc = "You can use recyclerview instead of scrollview.\nClick here to view selected gender and food.",groupID = 0))
        this.add(SubTitle(title = "Second Group (GENDER SELECTION)",groupID = 1))
        this.add(ContentRadioButton(id = 0,desc = "Male",groupID = 1))
        this.add(ContentRadioButton(id = 1,desc = "Female",groupID = 1))
        this.add(ContentRadioButton(id = 2,desc = "Unknown",groupID = 1))
        this.add(SubTitle(title = "Second Group (FOOD SELECTION)",groupID = 2))
        this.add(ContentCheckbox(id = 0,desc = "Bread",groupID = 2))
        this.add(ContentCheckbox(id = 1,desc = "Fish",groupID = 2))
        this.add(ContentCheckbox(id = 2,desc = "Meat",groupID = 2))
        this.add(ContentCheckbox(id = 3,desc = "Rice",groupID = 2))
        this.add(ContentCheckbox(id = 4,desc = "Soda",groupID = 2))
        this.add(ContentCheckbox(id = 5,desc = "Cup Cake",groupID = 2))
        this.add(ContentCheckbox(id = 6,desc = "Roll Cake",groupID = 2))
        this.add(ContentCheckbox(id = 7,desc = "Candy",groupID = 2))
        this.add(ContentCheckbox(id = 8,desc = "Cold Water",groupID = 2))
        this.add(Footer(desc = "made simple by @github.com/jamedeperio"))
    }
    private var selectedItem=""
    override fun loadList(): Disposable  = Observable.fromIterable(dataList)
    .subscribeOn(Schedulers.io())
    .observeOn(Schedulers.newThread())
    .doOnNext { adapter.addNewItem(it) }
    .subscribe()

    override fun processRadioGroup(groupID: Int, radioButtonID: Int):Disposable = Observable.fromIterable(adapter.getRadioButtonData(groupID,radioButtonID))
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .map { it as ContentRadioButton }
            .doOnNext { it.isChecked=false }
            .doOnComplete { adapter.refreshList() }
            .subscribe()

    override fun processSelectedItem(): Disposable = Observable.fromIterable(adapter.getSelectedItem())
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.newThread())
            .doOnNext {
                if (it is ContentRadioButton) selectedItem+="${it.desc}\n"
                else if (it is ContentCheckbox) selectedItem+="${it.desc}\n"
            }
            .doOnComplete {
                viewMethod.showBasicDialog("SelectedItem:",selectedItem)
                selectedItem=""
            }
            .subscribe()
}