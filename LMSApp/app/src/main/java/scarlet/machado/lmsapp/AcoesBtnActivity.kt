package scarlet.machado.lmsapp

import android.os.Bundle
import kotlinx.android.synthetic.main.toolbar.*

class AcoesBtnActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configurar)

        setSupportActionBar(toolbar)

    }
}