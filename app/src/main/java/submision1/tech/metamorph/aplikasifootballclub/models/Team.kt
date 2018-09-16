package submision1.tech.metamorph.aplikasifootballclub.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Team (val name: String?, val image:Int?, val description: String?) : Parcelable
