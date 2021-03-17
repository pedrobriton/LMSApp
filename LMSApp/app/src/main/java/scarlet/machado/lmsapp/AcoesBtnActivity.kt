package scarlet.machado.lmsapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*

class AcoesBtnActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acoesbtn)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



    }

override fun onCreateOptionsMenu(menu: Menu?): Boolean {
    return true
}

override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId

    if(id == android.R.id.home){
        finish()
    }

    else if(id == android.R.id.home){
        finish()
    }

    return super.onOptionsItemSelected(item)
}

}