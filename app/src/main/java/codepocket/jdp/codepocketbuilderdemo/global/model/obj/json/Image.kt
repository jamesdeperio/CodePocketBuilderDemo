package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Image (
    @field:[SerializedName("width")]
    var width: Int = 0,
    @field:[SerializedName("height")]
    var height: Int = 0,
    @field:[SerializedName("link")]
    var link: String? = null,
    @field:[SerializedName("title")]
    var title: String? = null,
    @field:[SerializedName("url")]
    var url: String? = null
)