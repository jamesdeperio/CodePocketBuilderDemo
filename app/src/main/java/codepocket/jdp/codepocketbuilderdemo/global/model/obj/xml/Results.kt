package codepocket.jdp.codepocketbuilderdemo.global.model.obj.xml

import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "results")
data class Results(
        @field:[Element(name = "channel")]
        var channel: Channel? = null
)