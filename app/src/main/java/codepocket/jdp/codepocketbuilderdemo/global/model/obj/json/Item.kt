package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName
import java.util.*

data class Item (
    @field:[SerializedName("forecast")]
    var forecast: List<Forecast> = ArrayList(),
    @field:[SerializedName("lat")]
    var lat: Double = 0.toDouble(),
    @field:[SerializedName("long")]
    var longitude: Double = 0.toDouble(),
    @field:[SerializedName("link")]
    var link: String? = null,
    @field:[SerializedName("description")]
    var description: String? = null,
    @field:[SerializedName("title")]
    var title: String? = null,
    @field:[SerializedName("pubDate")]
    var pubDate: String? = null,
    @field:[SerializedName("condition")]
    var condition: Condition? = null,
    @field:[SerializedName("guid")]
    var guid: Guid? = null
)