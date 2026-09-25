package com.example.data

data class MasjidItem(
    val id: String,
    val name: String,
    val area: String,
    val city: String,
    val state: String,
    val fajrOffset: Int = 0,
    val dhuhrOffset: Int = 0,
    val asrOffset: Int = 0,
    val maghribOffset: Int = 0,
    val ishaOffset: Int = 0,
    val fajrJammatOffset: Int = 25,
    val dhuhrJammatOffset: Int = 20,
    val asrJammatOffset: Int = 20,
    val maghribJammatOffset: Int = 10,
    val ishaJammatOffset: Int = 20,
    val jumahAzanTime: String = "12:30",
    val jumahJammatTime: String = "13:30"
)

fun adjustTime(time24: String, offsetMinutes: Int): String {
    if (!time24.contains(":")) return time24
    val parts = time24.split(":")
    val h = parts[0].toIntOrNull() ?: return time24
    val m = parts[1].toIntOrNull() ?: return time24
    var total = h * 60 + m + offsetMinutes
    while (total < 0) total += 1440
    total %= 1440
    return String.format(java.util.Locale.US, "%02d:%02d", total / 60, total % 60)
}

fun AzanTiming.applyMasjidOffsets(masjid: MasjidItem): AzanTiming {
    return this.copy(
        fajr = adjustTime(fajr, masjid.fajrOffset),
        dhuhr = adjustTime(dhuhr, masjid.dhuhrOffset),
        asr = adjustTime(asr, masjid.asrOffset),
        maghrib = adjustTime(maghrib, masjid.maghribOffset),
        isha = adjustTime(isha, masjid.ishaOffset)
    )
}

object MasjidRepository {
    val defaultMasjid = MasjidItem(
        id = "delhi_jama_masjid",
        name = "Jama Masjid",
        area = "Old Delhi",
        city = "Delhi",
        state = "Delhi",
        fajrOffset = 0,
        dhuhrOffset = 0,
        asrOffset = 0,
        maghribOffset = 0,
        ishaOffset = 0,
        fajrJammatOffset = 25,
        dhuhrJammatOffset = 20,
        asrJammatOffset = 20,
        maghribJammatOffset = 10,
        ishaJammatOffset = 20,
        jumahAzanTime = "12:30",
        jumahJammatTime = "13:30"
    )

    val masajid: List<MasjidItem> = listOf(
        // DELHI
        defaultMasjid,
        MasjidItem("delhi_fatehpuri", "Fatehpuri Masjid", "Chandni Chowk", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_nizamuddin", "Dargah Nizamuddin Auliya Masjid", "Nizamuddin West", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_sunehri", "Sunehri Masjid", "Chandni Chowk", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_jamia", "Central Jamia Masjid", "Jamia Millia Islamia", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_zeenat", "Zeenat-ul-Masajid (Ghata Masjid)", "Daryaganj", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_quba", "Masjid-e-Quba", "Abul Fazal Enclave", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_madina", "Madina Masjid", "Batla House, Okhla", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_bilal", "Masjid-e-Bilal", "Seelampur", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_khirki", "Khirki Masjid", "Malviya Nagar", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_kalan", "Kalan Masjid", "Turkman Gate", "Delhi", "Delhi", 0, 0, 0, 0, 0),
        MasjidItem("delhi_moth", "Moth Ki Masjid", "South Extension", "Delhi", "Delhi", 0, 0, 0, 0, 0),

        // MUMBAI & MAHARASHTRA
        MasjidItem("mumbai_haji_ali", "Haji Ali Dargah & Masjid", "Worli", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18, 25, 20, 20, 10, 20, "12:45", "13:45"),
        MasjidItem("mumbai_minara", "Minara Masjid", "Mohammad Ali Road", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18, 25, 20, 20, 10, 20, "12:45", "13:45"),
        MasjidItem("mumbai_jama", "Jama Masjid Bombay", "Crawford Market", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_mahim", "Makhdoom Mahimi Shahi Masjid", "Mahim West", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_zakaria", "Zakaria Masjid", "Mandvi", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_anjuman", "Anjuman-i-Islam Central Masjid", "CST", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_bandra", "Bandra Jama Masjid", "Bandra West", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_kurla", "Markaz Masjid Kurla", "Kurla West", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_andheri", "Andheri Jama Masjid", "S.V. Road, Andheri", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_mominpura", "Mominpura Badi Masjid", "Byculla", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_govandi", "Deonar Jama Masjid", "Govandi", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("mumbai_jogeshwari", "Millat Nagar Jama Masjid", "Jogeshwari West", "Mumbai", "Maharashtra", 15, 18, 18, 18, 18),
        MasjidItem("pune_chand_tara", "Chand Tara Masjid", "Nana Peth", "Pune", "Maharashtra", 12, 15, 15, 15, 15),
        MasjidItem("pune_camp", "Camp Jama Masjid", "Cantonment", "Pune", "Maharashtra", 12, 15, 15, 15, 15),
        MasjidItem("pune_kausar", "Kausar Baug Masjid", "Kondhwa", "Pune", "Maharashtra", 12, 15, 15, 15, 15),
        MasjidItem("aurangabad_killa", "Jama Masjid Killa Arrak", "Old City", "Aurangabad", "Maharashtra", 10, 12, 12, 12, 12),
        MasjidItem("aurangabad_kali", "Kali Masjid", "Juna Bazaar", "Aurangabad", "Maharashtra", 10, 12, 12, 12, 12),
        MasjidItem("nagpur_jama", "Badi Jama Masjid Mominpura", "Mominpura", "Nagpur", "Maharashtra", 2, 4, 4, 4, 4),
        MasjidItem("nashik_jama", "Jama Masjid Dudh Bazaar", "Old Nashik", "Nashik", "Maharashtra", 12, 15, 15, 15, 15),
        MasjidItem("thane_jama", "Thane Jama Masjid", "Station Road", "Thane", "Maharashtra", 15, 18, 18, 18, 18),

        // HYDERABAD & TELANGANA
        MasjidItem("hyd_makkah", "Makkah Masjid", "Charminar", "Hyderabad", "Telangana", -5, -6, -6, -6, -6, 25, 20, 20, 10, 20, "12:30", "13:30"),
        MasjidItem("hyd_shahi", "Shahi Masjid Public Gardens", "Nampally", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_toli", "Toli Masjid", "Karwan", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_spanish", "Spanish Mosque (Begumpet)", "Begumpet", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_azizia", "Masjid-e-Azizia", "Humayun Nagar", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_kulsumpura", "Kulsumpura Jama Masjid", "Karwan Sahu", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_begumpet", "Begumpet Central Mosque", "Secunderabad", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_hayat", "Hayat Bakshi Mosque", "Hayathnagar", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_musheerabad", "Musheerabad Badi Masjid", "Musheerabad", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_noor", "Masjid-e-Noor", "Banjara Hills", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_darussalam", "Darussalam Masjid", "Aghapura", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("hyd_chaderghat", "Masjid-e-Bilal", "Chaderghat", "Hyderabad", "Telangana", -5, -6, -6, -6, -6),
        MasjidItem("tg_warangal_jama", "Shahi Jama Masjid", "Kazipet", "Warangal", "Telangana", -6, -7, -7, -7, -7),
        MasjidItem("tg_nizamabad_jama", "Badi Masjid", "Barkatpura", "Nizamabad", "Telangana", -4, -5, -5, -5, -5),

        // KOLKATA & WEST BENGAL
        MasjidItem("kol_nakhoda", "Nakhoda Masjid", "Chitpur", "Kolkata", "West Bengal", -24, -25, -25, -25, -25, 25, 20, 20, 10, 20, "12:15", "13:15"),
        MasjidItem("kol_tipu_sultan", "Tipu Sultan Shahi Mosque", "Dharmatala / Esplanade", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_basri", "Basri Shah Mosque", "Seth Pukur Road", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_rajabazar", "Rajabazar Jama Masjid", "Narkeldanga Main Road", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_park_circus", "Park Circus 7-Point Shahi Masjid", "Park Circus", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_metiabruz", "Metiabruz Shahi Jama Masjid", "Garden Reach", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_khidirpur", "Khidirpur Shahi Jama Masjid", "Kidderpore", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_colootola", "Colootola Badi Masjid", "Phears Lane", "Kolkata", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("kol_hooghly", "Hooghly Imambara Mosque", "Hooghly Ghat", "Hooghly", "West Bengal", -24, -25, -25, -25, -25),
        MasjidItem("wb_asansol_jama", "Asansol Central Jama Masjid", "Railpar", "Asansol", "West Bengal", -22, -23, -23, -23, -23),
        MasjidItem("wb_siliguri_jama", "Siliguri Jama Masjid", "Hospital Road", "Siliguri", "West Bengal", -22, -24, -24, -24, -24),

        // LUCKNOW & UTTAR PRADESH
        MasjidItem("lko_asfi", "Asfi Mosque (Bara Imambara)", "Husainabad", "Lucknow", "Uttar Pradesh", -10, -10, -10, -10, -10, 25, 20, 20, 10, 20, "12:20", "13:20"),
        MasjidItem("lko_tile_wali", "Tile Wali Masjid", "Gomti Bank, Chowk", "Lucknow", "Uttar Pradesh", -10, -10, -10, -10, -10),
        MasjidItem("lko_tehsin", "Jama Masjid Tehsin Ganj", "Husainabad", "Lucknow", "Uttar Pradesh", -10, -10, -10, -10, -10),
        MasjidItem("lko_nadwa", "Nadwatul Ulama Central Mosque", "Tagore Marg", "Lucknow", "Uttar Pradesh", -10, -10, -10, -10, -10),
        MasjidItem("lko_aishbagh", "Aishbagh Eidgah Masjid", "Aishbagh", "Lucknow", "Uttar Pradesh", -10, -10, -10, -10, -10),
        MasjidItem("lko_aminabad", "Aminabad Jama Masjid", "Aminabad", "Lucknow", "Uttar Pradesh", -10, -10, -10, -10, -10),
        MasjidItem("knp_moolganj", "Jama Masjid Moolganj", "Moolganj Market", "Kanpur", "Uttar Pradesh", -8, -9, -9, -9, -9),
        MasjidItem("knp_parade", "Parade Badi Masjid", "Parade Ground", "Kanpur", "Uttar Pradesh", -8, -9, -9, -9, -9),
        MasjidItem("knp_halim", "Halim Muslim Campus Mosque", "Chamanganj", "Kanpur", "Uttar Pradesh", -8, -9, -9, -9, -9),
        MasjidItem("ali_amu_sir_syed", "Sir Syed Hall Mosque", "AMU Campus", "Aligarh", "Uttar Pradesh", -2, -3, -3, -3, -3),
        MasjidItem("ali_univ_jama", "University Jama Masjid", "AMU", "Aligarh", "Uttar Pradesh", -2, -3, -3, -3, -3),
        MasjidItem("bly_aala_hazrat", "Dargah-e-Aala Hazrat Masjid", "Saudagaran", "Bareilly", "Uttar Pradesh", -4, -5, -5, -5, -5),
        MasjidItem("bly_shahi", "Shahi Jama Masjid", "Bara Bazaar", "Bareilly", "Uttar Pradesh", -4, -5, -5, -5, -5),
        MasjidItem("vns_gyanvapi", "Gyanvapi / Alamgir Mosque", "Chowk", "Varanasi", "Uttar Pradesh", -14, -14, -14, -14, -14),
        MasjidItem("agr_jama", "Jama Masjid Kinari Bazaar", "Kinari Bazaar", "Agra", "Uttar Pradesh", 0, 0, 0, 0, 0),
        MasjidItem("agr_fatehpur", "Fatehpur Sikri Jama Masjid", "Fatehpur Sikri", "Agra", "Uttar Pradesh", 0, 0, 0, 0, 0),
        MasjidItem("mrt_kotwali", "Jama Masjid Kotwali", "Kotwali", "Meerut", "Uttar Pradesh", 0, 0, 0, 0, 0),
        MasjidItem("sre_saharanpur", "Badi Jama Masjid", "Chowk", "Saharanpur", "Uttar Pradesh", 0, 0, 0, 0, 0),
        MasjidItem("gkp_gorakhpur", "Jama Masjid Urdu Bazaar", "Urdu Bazaar", "Gorakhpur", "Uttar Pradesh", -16, -16, -16, -16, -16),
        MasjidItem("mor_moradabad", "Shahi Jama Masjid", "Court Road", "Moradabad", "Uttar Pradesh", -3, -4, -4, -4, -4),

        // BANGALORE & KARNATAKA
        MasjidItem("blr_city_market", "City Jama Masjid", "City Market", "Bangalore", "Karnataka", -8, -8, -8, -8, -8, 25, 20, 20, 10, 20, "12:25", "13:25"),
        MasjidItem("blr_shivajinagar", "Jamia Masjid Shivajinagar", "Shivajinagar", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("blr_bilal", "Masjid-e-Bilal", "Bannerghatta Road", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("blr_tawakkal", "Tawakkal Mastan Masjid", "Cottonpet", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("blr_commercial", "Madina Masjid", "Commercial Street", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("blr_khadria", "Masjid-e-Khadria", "Millers Road", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("blr_frazer", "Frazer Town Central Mosque", "Coles Road", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("blr_jayanagar", "Jayanagar 4th Block Jama Masjid", "Jayanagar", "Bangalore", "Karnataka", -8, -8, -8, -8, -8),
        MasjidItem("mys_jamia", "Jamia Masjid Ashoka Road", "Lashkar Mohalla", "Mysore", "Karnataka", -7, -7, -7, -7, -7),
        MasjidItem("glb_shahi", "Shahi Masjid Gulbarga", "Fort Area", "Kalaburagi (Gulbarga)", "Karnataka", -6, -6, -6, -6, -6),
        MasjidItem("hbl_hubli", "Badi Jama Masjid Hubli", "Daji Peth", "Hubli", "Karnataka", -4, -4, -4, -4, -4),
        MasjidItem("mng_mangalore", "Zeenath Baksh Juma Masjid", "Bunder", "Mangalore", "Karnataka", -6, -6, -6, -6, -6),
        MasjidItem("bel_belgaum", "Jama Masjid Belagavi", "Camp", "Belgaum", "Karnataka", -3, -3, -3, -3, -3),

        // CHENNAI & TAMIL NADU
        MasjidItem("chn_wallajah", "Wallajah Big Mosque", "Triplicane", "Chennai", "Tamil Nadu", -14, -14, -14, -14, -14, 25, 20, 20, 10, 20, "12:20", "13:20"),
        MasjidItem("chn_thousand_lights", "Thousand Lights Mosque", "Anna Salai", "Chennai", "Tamil Nadu", -14, -14, -14, -14, -14),
        MasjidItem("chn_makkah", "Makkah Masjid Mount Road", "Anna Salai", "Chennai", "Tamil Nadu", -14, -14, -14, -14, -14),
        MasjidItem("chn_madhavaram", "Madhavaram Jama Masjid", "Madhavaram", "Chennai", "Tamil Nadu", -14, -14, -14, -14, -14),
        MasjidItem("chn_royapettah", "Royapettah Jama Masjid", "Royapettah", "Chennai", "Tamil Nadu", -14, -14, -14, -14, -14),
        MasjidItem("chn_perambur", "Perambur Shahi Mosque", "Perambur", "Chennai", "Tamil Nadu", -14, -14, -14, -14, -14),
        MasjidItem("tn_nagore", "Nagore Dargah Shahi Masjid", "Nagore", "Nagapattinam", "Tamil Nadu", -15, -15, -15, -15, -15),
        MasjidItem("tn_madurai", "Kazimar Big Mosque", "Kazimar Street", "Madurai", "Tamil Nadu", -15, -15, -15, -15, -15),
        MasjidItem("tn_trichy", "Trichy Big Mosque", "Palakkarai", "Tiruchirappalli", "Tamil Nadu", -14, -14, -14, -14, -14),
        MasjidItem("tn_coimbatore", "Athar Jamad Masjid", "Big Bazaar Street", "Coimbatore", "Tamil Nadu", -12, -12, -12, -12, -12),

        // AHMEDABAD & GUJARAT
        MasjidItem("amd_jama", "Jama Masjid Manek Chowk", "Manek Chowk", "Ahmedabad", "Gujarat", 18, 18, 18, 18, 18, 25, 20, 20, 10, 20, "12:50", "13:45"),
        MasjidItem("amd_sidi_saiyyed", "Sidi Saiyyed Mosque", "Lal Darwaja", "Ahmedabad", "Gujarat", 18, 18, 18, 18, 18),
        MasjidItem("amd_sarkhej", "Sarkhej Roza Mosque", "Makarba", "Ahmedabad", "Gujarat", 18, 18, 18, 18, 18),
        MasjidItem("amd_rani_sipri", "Rani Sipri Mosque", "Astodia", "Ahmedabad", "Gujarat", 18, 18, 18, 18, 18),
        MasjidItem("amd_shah_alam", "Shah-e-Alam Roza Masjid", "Shah Alam", "Ahmedabad", "Gujarat", 18, 18, 18, 18, 18),
        MasjidItem("amd_juhapura", "Juhapura Markaz Masjid", "Sarkhej Road", "Ahmedabad", "Gujarat", 18, 18, 18, 18, 18),
        MasjidItem("sur_rander", "Mughal Masjid Rander", "Rander", "Surat", "Gujarat", 16, 16, 16, 16, 16),
        MasjidItem("sur_nanpura", "Jama Masjid Nanpura", "Nanpura", "Surat", "Gujarat", 16, 16, 16, 16, 16),
        MasjidItem("guj_navsari", "Navsari Badi Masjid", "Mota Bazaar", "Navsari", "Gujarat", 16, 16, 16, 16, 16),
        MasjidItem("vad_mandvi", "Jama Masjid Mandvi", "Mandvi Gate", "Vadodara", "Gujarat", 17, 17, 17, 17, 17),
        MasjidItem("guj_rajkot", "Rajkot Jama Masjid", "Dharmendra Road", "Rajkot", "Gujarat", 22, 22, 22, 22, 22),
        MasjidItem("guj_bhavnagar", "Bhavnagar Jama Masjid", "Khar Gate", "Bhavnagar", "Gujarat", 20, 20, 20, 20, 20),

        // BHOPAL & MADHYA PRADESH
        MasjidItem("bho_taj_ul", "Taj-ul-Masajid", "Kohefiza", "Bhopal", "Madhya Pradesh", 2, 2, 2, 2, 2, 25, 20, 20, 10, 20, "12:35", "13:30"),
        MasjidItem("bho_moti", "Moti Masjid", "Hawamahal Road", "Bhopal", "Madhya Pradesh", 2, 2, 2, 2, 2),
        MasjidItem("bho_dhai", "Dhai Seedhi Ki Masjid", "Gandhi Medical Campus", "Bhopal", "Madhya Pradesh", 2, 2, 2, 2, 2),
        MasjidItem("bho_chowk", "Jama Masjid Chowk", "Ibrahimpura", "Bhopal", "Madhya Pradesh", 2, 2, 2, 2, 2),
        MasjidItem("bho_tarjuma", "Masjid Tarjuma", "Shahjahanabad", "Bhopal", "Madhya Pradesh", 2, 2, 2, 2, 2),
        MasjidItem("bho_idgah", "Idgah Hills Shahi Masjid", "Idgah Hills", "Bhopal", "Madhya Pradesh", 2, 2, 2, 2, 2),
        MasjidItem("mp_indore", "Jama Masjid Indore", "Bada Sarafa", "Indore", "Madhya Pradesh", 6, 6, 6, 6, 6),
        MasjidItem("mp_gwalior", "Shahi Masjid Gwalior Fort", "Gwalior Fort", "Gwalior", "Madhya Pradesh", -1, -1, -1, -1, -1),
        MasjidItem("mp_jabalpur", "Badi Jama Masjid Jabalpur", "Lordganj", "Jabalpur", "Madhya Pradesh", -6, -6, -6, -6, -6),
        MasjidItem("mp_ujjain", "Jama Masjid Ujjain", "Begum Bagh", "Ujjain", "Madhya Pradesh", 7, 7, 7, 7, 7),

        // SRINAGAR & JAMMU & KASHMIR
        MasjidItem("srn_jamia", "Jamia Masjid Srinagar", "Nowhatta", "Srinagar", "Jammu & Kashmir", 6, 8, 8, 8, 8, 25, 20, 20, 10, 20, "12:40", "13:45"),
        MasjidItem("srn_hazratbal", "Hazratbal Shrine Mosque", "Dal Lake", "Srinagar", "Jammu & Kashmir", 6, 8, 8, 8, 8),
        MasjidItem("srn_khanqah", "Shah-e-Hamdan Khanqah", "Zaina Kadal", "Srinagar", "Jammu & Kashmir", 6, 8, 8, 8, 8),
        MasjidItem("srn_dastgeer", "Dastgeer Sahib Mosque", "Khanyar", "Srinagar", "Jammu & Kashmir", 6, 8, 8, 8, 8),
        MasjidItem("srn_pathar", "Pathar Masjid", "Heritage Zone", "Srinagar", "Jammu & Kashmir", 6, 8, 8, 8, 8),
        MasjidItem("srn_aali", "Aali Masjid", "Eidgah Ground", "Srinagar", "Jammu & Kashmir", 6, 8, 8, 8, 8),
        MasjidItem("jk_jammu_tawi", "Jamia Masjid Talab Khatikan", "Talab Khatikan", "Jammu", "Jammu & Kashmir", 4, 6, 6, 6, 6),
        MasjidItem("jk_anantnag", "Reshi Sahib Jama Masjid", "KP Road", "Anantnag", "Jammu & Kashmir", 6, 8, 8, 8, 8),

        // BIHAR & JHARKHAND
        MasjidItem("pat_pathar", "Pathar Ki Masjid", "Ganga Path", "Patna", "Bihar", -18, -18, -18, -18, -18, 25, 20, 20, 10, 20, "12:15", "13:15"),
        MasjidItem("pat_digha", "Digha Jama Masjid", "Digha Ghat", "Patna", "Bihar", -18, -18, -18, -18, -18),
        MasjidItem("pat_sabzibagh", "Sabzibagh Badi Masjid", "Sabzibagh", "Patna", "Bihar", -18, -18, -18, -18, -18),
        MasjidItem("pat_phulwari", "Khanqah Mujibia Shahi Masjid", "Phulwari Sharif", "Patna", "Bihar", -18, -18, -18, -18, -18),
        MasjidItem("bih_maner", "Shahi Masjid Maner Sharif", "Maner", "Patna Rural", "Bihar", -18, -18, -18, -18, -18),
        MasjidItem("bih_gaya", "Gaya Shahi Jama Masjid", "Chowk", "Gaya", "Bihar", -18, -18, -18, -18, -18),
        MasjidItem("bih_bhagalpur", "Shahi Jama Masjid Champanagar", "Champanagar", "Bhagalpur", "Bihar", -20, -20, -20, -20, -20),
        MasjidItem("bih_muzaffarpur", "Badi Masjid Company Bagh", "Company Bagh", "Muzaffarpur", "Bihar", -18, -18, -18, -18, -18),
        MasjidItem("jhk_ranchi", "Main Road Badi Masjid", "Main Road, Hindpiri", "Ranchi", "Jharkhand", -16, -16, -16, -16, -16),
        MasjidItem("jhk_jamshedpur", "Sakchi Central Jama Masjid", "Sakchi Market", "Jamshedpur", "Jharkhand", -18, -18, -18, -18, -18),
        MasjidItem("jhk_dhanbad", "Badi Masjid Purana Bazar", "Purana Bazar", "Dhanbad", "Jharkhand", -18, -18, -18, -18, -18),

        // RAJASTHAN
        MasjidItem("ajm_akbari", "Dargah Sharif Akbari Masjid", "Dargah Bazar", "Ajmer", "Rajasthan", 8, 8, 8, 8, 8, 25, 20, 20, 10, 20, "12:40", "13:35"),
        MasjidItem("ajm_shah_jahani", "Shah Jahani Mosque", "Dargah Sharif", "Ajmer", "Rajasthan", 8, 8, 8, 8, 8),
        MasjidItem("ajm_adhai_din", "Adhai Din Ka Jhonpra Mosque", "Dargah Foothills", "Ajmer", "Rajasthan", 8, 8, 8, 8, 8),
        MasjidItem("jai_johari", "Jama Masjid Johari Bazar", "Johari Bazar", "Jaipur", "Rajasthan", 6, 6, 6, 6, 6),
        MasjidItem("jai_char_darwaza", "Char Darwaza Jama Masjid", "Ramganj", "Jaipur", "Rajasthan", 6, 6, 6, 6, 6),
        MasjidItem("jai_moti_doongri", "Muslim Musafirkhana Masjid", "Moti Doongri Road", "Jaipur", "Rajasthan", 6, 6, 6, 6, 6),
        MasjidItem("raj_jodhpur", "Shahi Jama Masjid Sojati Gate", "Sojati Gate", "Jodhpur", "Rajasthan", 14, 14, 14, 14, 14),
        MasjidItem("raj_kota", "Badi Jama Masjid Kota", "Rampura", "Kota", "Rajasthan", 5, 5, 5, 5, 5),
        MasjidItem("raj_udaipur", "Jama Masjid Hathipole", "Hathipole", "Udaipur", "Rajasthan", 12, 12, 12, 12, 12),

        // KERALA & OTHER REGIONS
        MasjidItem("ker_cheraman", "Cheraman Juma Mosque (629 CE)", "Methala, Kodungallur", "Thrissur", "Kerala", -12, -12, -12, -12, -12, 25, 20, 20, 10, 20, "12:25", "13:30"),
        MasjidItem("ker_mishkal", "Mishkal Mosque Kuttichira", "Kuttichira", "Calicut", "Kerala", -10, -10, -10, -10, -10),
        MasjidItem("ker_muchundi", "Muchundi Mosque Kuttichira", "Kuttichira", "Calicut", "Kerala", -10, -10, -10, -10, -10),
        MasjidItem("ker_palayam", "Palayam Juma Masjid", "Palayam", "Thiruvananthapuram", "Kerala", -14, -14, -14, -14, -14),
        MasjidItem("ker_ernakulam", "Broadway Juma Masjid", "Marine Drive", "Kochi", "Kerala", -12, -12, -12, -12, -12),
        MasjidItem("goa_panaji", "Jama Masjid Panaji", "Fontainhas", "Panaji", "Goa", 4, 4, 4, 4, 4),
        MasjidItem("asm_guwahati", "Panbazar Central Jama Masjid", "Panbazar", "Guwahati", "Assam", -32, -32, -32, -32, -32),
        MasjidItem("asm_dibrugarh", "Dibrugarh Badi Jama Masjid", "Marwari Patty", "Dibrugarh", "Assam", -36, -36, -36, -36, -36),
        MasjidItem("od_cuttack", "Kadam-e-Rasool Shahi Mosque", "Dargah Bazar", "Cuttack", "Odisha", -18, -18, -18, -18, -18),
        MasjidItem("od_bhubaneswar", "Capital Mosque Unit 4", "Bhauma Nagar", "Bhubaneswar", "Odisha", -18, -18, -18, -18, -18),
        MasjidItem("chg_raipur", "Badi Jama Masjid Malviya Road", "Malviya Road", "Raipur", "Chhattisgarh", -10, -10, -10, -10, -10)
    )

    fun getMasjidById(id: String): MasjidItem {
        return masajid.find { it.id == id } ?: defaultMasjid
    }
}
