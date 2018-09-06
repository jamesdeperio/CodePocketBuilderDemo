package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Condition (
    @field:[SerializedName("temp")]
    var temp: Int = 0,
    @field:[SerializedName("code")]
    var code: Int = 0,
    @field:[SerializedName("date")]
    var date: String? = null,
    @field:[SerializedName("text")]
    var text: String? = null
)