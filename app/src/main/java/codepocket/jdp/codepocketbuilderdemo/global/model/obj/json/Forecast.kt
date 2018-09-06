package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Forecast (
    @field:[SerializedName("high")]
    var high: Int = 0,
    @field:[SerializedName("code")]
    var code: Int = 0,
    @field:[SerializedName("low")]
    var low: Int = 0,
    @field:[SerializedName("date")]
    var date: String? = null,
    @field:[SerializedName("text")]
    var text: String? = null,
    @field:[SerializedName("day")]
    var day: String? = null
)