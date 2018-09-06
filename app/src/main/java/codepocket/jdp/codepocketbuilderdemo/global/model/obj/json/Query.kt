package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Query (
        @field:[SerializedName("count")]
        var count: Int = 0,
        @field:[SerializedName("created")]
        var created: String? = null,
        @field:[SerializedName("lang")]
        var lang: String? = null,
        @field:[SerializedName("results")]
        var results: Results? = null
)