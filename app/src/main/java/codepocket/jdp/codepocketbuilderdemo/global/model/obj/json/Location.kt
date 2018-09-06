package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Location (
    @field:[SerializedName("country")]
    var country: String? = null,
    @field:[SerializedName("city")]
    var city: String? = null,
    @field:[SerializedName("region")]
    var region: String? = null
)