package codepocket.jdp.codepocketbuilderdemo.global.model.obj.json

import com.google.gson.annotations.SerializedName

data class Channel (
        @field:[SerializedName("ttl")]
        var ttl: Int = 0,
        @field:[SerializedName("lastBuildDate")]
        var lastBuildDate: String? = null,
        @field:[SerializedName("link")]
        var link: String? = null,
        @field:[SerializedName("description")]
        var description: String? = null,
        @field:[SerializedName("language")]
        var language: String? = null,
        @field:[SerializedName("title")]
        var title: String? = null,
        @field:[SerializedName("atmosphere")]
        var atmosphere: Atmosphere? = null,
        @field:[SerializedName("image")]
        var image: Image? = null,
        @field:[SerializedName("item")]
        var item: Item? = null,
        @field:[SerializedName("units")]
        var units: Units? = null,
        @field:[SerializedName("astronomy")]
        var astronomy: Astronomy? = null,
        @field:[SerializedName("location")]
        var location: Location? = null,
        @field:[SerializedName("wind")]
        var wind: Wind? = null
)