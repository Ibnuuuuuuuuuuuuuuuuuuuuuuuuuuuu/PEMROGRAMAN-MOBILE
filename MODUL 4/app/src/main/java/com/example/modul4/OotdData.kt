package com.example.modul4

data class Ootd(
    val id: Int,
    val title: String,
    val style: String,
    val description: String,
    val imageResId: Int,
    val gender: String
) {
    companion object {
        val ootdList = listOf(
            Ootd(1, "Block Core", "Streetwear", "gaya streetwear modern yang lahir dari semangat bereksperimen dan mengaburkan batas antara dunia olahraga dan fashion jalanan. " +
                    "Keunikannya terletak pada penggunaan jersey bola sebagai item utama, menjadikannya lebih dari sekadar simbol fandom—melainkan pernyataan gaya yang berani. " +
                    "Gaya ini merepresentasikan generasi muda yang dinamis, penuh karakter, dan tidak takut memadukan elemen yang tampak kontras. Block Core bukan hanya soal pakaian," +
                    " tapi juga tentang cara mengekspresikan diri dengan bebas dan orisinal." +
                    "\n\n Atasan: Jersey klub bola bergaya retro dengan motif kotak merah-putih dan logo “PACHA Ibiza” yang menonjol." +
                    "\n\n Bawahan: Celana wide leg bahan wol berwarna abu-abu tua, menciptakan kontras menarik antara sporty dan formal.", R.drawable.block_core_man, "Men"),

            Ootd(2, "Block Core", "Streetwear", " gaya streetwear modern yang lahir dari semangat bereksperimen dan mengaburkan batas antara dunia olahraga dan fashion jalanan. " +
                    "Keunikannya terletak pada penggunaan jersey bola sebagai item utama, menjadikannya lebih dari sekadar simbol fandom—melainkan pernyataan gaya yang berani. " +
                    "Gaya ini merepresentasikan generasi muda yang dinamis, penuh karakter, dan tidak takut memadukan elemen yang tampak kontras. Block Core bukan hanya soal pakaian, " +
                    "tapi juga tentang cara mengekspresikan diri dengan bebas dan orisinal." +
                    "\n\n Atasan: Jersey FC Barcelona dengan potongan crop top, menampilkan logo Nike dan sponsor Spotify yang mencolok." +
                    "\n\n Bawahan: Celana cargo hitam longgar, menciptakan siluet santai namun tetap bold.", R.drawable.block_core_girl, "Women"),

            Ootd(3, "Cottage Core", "Romantic", "gaya fashion yang terinspirasi dari kehidupan pedesaan yang tenang, romantis, dan penuh nostalgia. " +
                    "Gaya ini mengangkat elemen alami dan vintage—mulai dari motif bunga kecil, bahan katun atau linen, warna-warna hangat dan lembut," +
                    " hingga siluet yang mengalir dan nyaman. Cottage Core bukan hanya tentang penampilan, tetapi juga menggambarkan gaya hidup yang menghargai" +
                    " keindahan sederhana, kedekatan dengan alam, dan suasana yang damai." +
                    "\n\n Atasan: Sweater rajut motif folk berwarna dasar hitam dengan aksen pola merah-putih yang memberi kesan hangat." +
                    "\n\n Bawahan: Celana panjang corduroy coklat muda berpotongan longgar, menambah kesan earthy dan santai.", R.drawable.cottage_core_man, "Men"),

            Ootd(4, "Cottage Core", "Romantic", "gaya fashion yang terinspirasi dari kehidupan pedesaan yang tenang, romantis, dan penuh nostalgia." +
                    " Gaya ini mengangkat elemen alami dan vintage—mulai dari motif bunga kecil, bahan katun atau linen, warna-warna hangat dan lembut," +
                    " hingga siluet yang mengalir dan nyaman. Cottage Core bukan hanya tentang penampilan, tetapi juga menggambarkan gaya hidup yang menghargai " +
                    "keindahan sederhana, kedekatan dengan alam, dan suasana yang damai." +
                    "\n\n Atasan: Kardigan rajut tipis berwarna merah dipadukan dengan dress floral putih bermotif bunga kecil dan detail renda." +
                    "\n\n Bawahan: Dress panjang mengalir dengan potongan klasik dan aksen pita, menciptakan siluet lembut yang feminin.", R.drawable.cottage_core_girl, "Women"),

            Ootd(5, "Grunge", "Alternative", "Outfit bergaya grunge identik dengan kesan santai, berantakan yang terkesan effortless namun tetap keren. " +
                    "Ciri khasnya adalah dominasi warna gelap, layering, bahan denim, serta kaos band sebagai elemen penting. " +
                    "Gaya ini memadukan unsur musik alternatif dengan sikap anti-mainstream khas era 90-an." +
                    "\n\n Atasan: Kaos grafis berwarna hitam dilapisi kemeja flanel motif kotak merah-hijau yang terbuka, menciptakan tampilan layering khas grunge klasik." +
                    "\n\n Bawahan: Celana longgar berbahan corduroy hijau tua, memberi tekstur earthy yang sejalan dengan elemen grunge vintage.", R.drawable.grunge_man, "Men"),

            Ootd(6, "Grunge", "Alternative", "Outfit bergaya grunge identik dengan kesan santai, berantakan yang terkesan effortless namun tetap keren. " +
                    "Ciri khasnya adalah dominasi warna gelap, layering, bahan denim, serta kaos band sebagai elemen penting." +
                    " Gaya ini memadukan unsur musik alternatif dengan sikap anti-mainstream khas era 90-an." +
                    "\n\n Atasan: Kaos band The Beatles berwarna hitam kusam dengan print besar, memberikan nuansa retro dan rebellious." +
                    "\n\n Bawahan: Celana jeans baggy berpotongan longgar berwarna biru pudar, menambah kesan santai dan nonchalant.", R.drawable.grunge_girl, "Women"),

            Ootd(7, "Japanese Americana", "Fusion", "Outfit bergaya Japanese Americana memadukan gaya kasual klasik khas Amerika seperti denim dan workwear dengan sentuhan rapi, minimalis, dan estetika layering ala Jepang. " +
                    "Ciri khasnya meliputi jaket denim, celana berpotongan longgar, warna earthy seperti olive dan navy, serta perhatian terhadap siluet dan tekstur." +
                    "\n\n Atasan: Kemeja putih berkerah dengan dasi cokelat yang dilapisi jaket denim fitted berwarna indigo, menciptakan tampilan rapi dengan lapisan Americana yang kuat." +
                    "\n\n Bawahan: Celana workwear hijau zaitun berpotongan lurus yang terinspirasi dari gaya militer, menyeimbangkan kesan maskulin dan vintage.", R.drawable.japanese_americana_man, "Men"),

            Ootd(8, "Japanese Americana", "Fusion", "Outfit bergaya Japanese Americana memadukan gaya kasual klasik khas Amerika seperti denim dan workwear dengan sentuhan rapi, minimalis, dan estetika layering ala Jepang. " +
                    "Ciri khasnya meliputi jaket denim, celana berpotongan longgar, warna earthy seperti olive dan navy, serta perhatian terhadap siluet dan tekstur." +
                    "\n\n Atasan: Kaos bergaris hitam-putih bergaya Breton yang dimasukkan ke dalam celana, memberikan kesan clean namun santai. Sebuah jaket denim biru dikenakan secara kasual di bahu sebagai outer, menambah sentuhan Americana klasik." +
                    "\n\n Bawahan: Celana cargo hijau army berpotongan lebar yang memberi nuansa utilitarian khas workwear, sekaligus menciptakan siluet longgar yang modis dan nyaman.", R.drawable.japanese_americana_girl, "Women"),

            Ootd(9, "Old Money", "Classic", "Outfit bergaya Old Money mencerminkan kemewahan yang tidak mencolok, elegan, dan timeless. Gaya ini lekat dengan nuansa klasik, potongan yang rapi," +
                    " bahan berkualitas tinggi, serta warna-warna netral yang terkesan mahal. Tidak berfokus pada tren, tetapi pada keanggunan dan prestise." +
                    "\n\n Atasan: Kemeja putih klasik dengan kerah terbuka, memberikan kesan effortless dan bersih namun tetap terjaga rapi. Diselipkan ke dalam celana untuk tampilan yang lebih polished." +
                    "\n\n Bawahan: Celana wool cokelat berpotongan longgar dan pleated, menambah kesan sophisticated khas gentleman lama. ", R.drawable.old_money_man, "Men"),

            Ootd(10, "Old Money", "Classic", "Outfit bergaya Old Money mencerminkan kemewahan yang tidak mencolok, elegan, dan timeless. Gaya ini lekat dengan nuansa klasik, potongan yang rapi," +
                    " bahan berkualitas tinggi, serta warna-warna netral yang terkesan mahal. Tidak berfokus pada tren, tetapi pada keanggunan dan prestise." +
                    "\n\n Atasan: Kemeja satin berwarna ivory dengan detail kerah klasik, memberikan tampilan sophisticated yang mewah namun understated. Dipadukan dengan blazer oversized dalam nuansa beige yang memberikan siluet structured dan elegan." +
                    "\n\n Bawahan: Celana tailored high-waist warna senada yang jatuh longgar hingga menyentuh lantai, menegaskan citra refined dan berkelas.", R.drawable.old_money_girl, "Women"),

            Ootd(11, "Y2K", "Retro Futurism", "Outfit bergaya Y2K (Year 2000) identik dengan nuansa futuristik, playful, dan eksperimental yang merefleksikan semangat awal milenium. " +
                    "Gaya ini sering menggabungkan elemen-elemen seperti low-rise jeans, atasan ketat, bahan denim dengan efek faded, " +
                    "serta aksesori mencolok yang terinspirasi dari dunia pop culture, teknologi, dan fashion selebriti tahun 2000-an." +
                    "\n\n Atasan: Kemeja putih sebagai dasar dipadukan dengan sweater hitam dan jaket kulit hitam sebagai outer, menghasilkan tampilan layering maskulin dan berani yang populer di era awal 2000-an." +
                    "\n\n Bawahan: Celana jeans longgar berwarna hitam pudar, menciptakan kesan laid-back namun tetap tajam, selaras dengan gaya street style Y2K.", R.drawable.y2k_man, "Men"),

            Ootd(12, "Y2K", "Retro Futurism", "Outfit bergaya Y2K (Year 2000) identik dengan nuansa futuristik, playful, dan eksperimental yang merefleksikan semangat awal milenium. " +
                    "Gaya ini sering menggabungkan elemen-elemen seperti low-rise jeans, atasan ketat, bahan denim dengan efek faded, " +
                    "serta aksesori mencolok yang terinspirasi dari dunia pop culture, teknologi, dan fashion selebriti tahun 2000-an." +
                    "\n\n Atasan: Cropped cardigan abu-abu tua yang ketat dipadukan dengan tank top abu-abu muda, menciptakan tampilan layering yang menggoda dan edgy." +
                    "\n\n Bawahan: Celana jeans flare berpotongan low-rise dengan efek washed-out, memperkuat siluet tubuh dan nuansa retro futuristik khas Y2K.", R.drawable.y2k_girl, "Women")
        )

        fun getById(id: Int): Ootd? = ootdList.find { it.id == id }
    }
}