package kh.edu.rupp.ite.daytoon.model

class StoryNovel {

        private var id: String? = null
        private var title: String? = null
        private var description: String? = null
        private var img: String? = null


        fun getId(): String? {
                return id
        }

        fun setId(id: String?) {
                this.id = id
        }

        fun getTitle(): String? {
                return title
        }

        fun setTitle(title: String?) {
                this.title = title
        }

        fun getDescription(): String? {
                return description
        }

        fun setDescription(description: String?) {
                this.description = description
        }

        fun getImg(): String? {
                return img
        }

        fun setImg(img: String?) {
                this.img = img
        }
}
