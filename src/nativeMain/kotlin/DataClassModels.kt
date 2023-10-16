import android.graphics.Color

data class Blog(
    val title: String,
    val desc: String,
    val img: String, // path to image
    val date: Long,
    val addions: List<TextChips>
) {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "title" to title,
            "desc" to desc,
            "date" to date,
            "img" to img,
            "addions" to addions.map { it.toMap() }
        )
    }

    companion object {
        fun fromMap(map: Map<String, Any>): Blog {
            return Blog(
                title = map["title"] as String,
                desc = map["desc"] as String,
                date = map["date"] as Long,
                img = map["img"] as String,
                addions = (map["addions"] as List<Map<String, Any>>).map { TextChips.fromMap(it) }
            )
        }
    }

    fun toJson(): String {
        return Gson().toJson(toMap())
    }

    companion object {
        fun fromJson(source: String): Blog {
            val map = Gson().fromJson(source, Map::class.java) as Map<String, Any>
            return fromMap(map)
        }
    }
}

data class TextChips(
    val txt: String,
    val textColor: Int,
    val bgColor: Int
) {
    fun toMap(): Map<String, Any> {
        return mapOf(
            "txt" to txt,
            "textColor" to textColor,
            "bgColor" to bgColor
        )
    }

    companion object {
        fun fromMap(map: Map<String, Any>): TextChips {
            return TextChips(
                txt = map["txt"] as String,
                textColor = (map["textColor"] as Long).toInt(),
                bgColor = (map["bgColor"] as Long).toInt()
            )
        }
    }

    fun toJson(): String {
        return Gson().toJson(toMap())
    }

    companion object {
        fun fromJson(source: String): TextChips {
            val map = Gson().fromJson(source, Map::class.java) as Map<String, Any>
            return fromMap(map)
        }
    }
}
