package com.example.week_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button
        val btnGetID: Button = findViewById(R.id.btnGetID)

        btnGetID.setOnClickListener(){
            val rq: RequestQueue = Volley.newRequestQueue(this)

            val ogjReq: JsonObjectRequest = JsonObjectRequest(
                //default is get method if not mention
                Request.Method.GET,
                "http://demo.onmyfinger.com/home/getById?id=w111",
                null,
                Response.Listener {
                    response -> try{
                        val obj:JSONObject = response

                        val tvResult: TextView = findViewById(R.id.tvResult)
                        tvResult.setText(obj.getString("name"))


                    }catch (e:JSONException){
                        val tvResult: TextView = findViewById(R.id.tvResult)
                        tvResult.setText(e.message)
                    }
                }, Response.ErrorListener {
                    error -> findViewById<TextView>(R.id.tvResult).setText(error.message)
                    //val tvResult: TextView = findViewById(R.id.tvResult)
                    //tvResult.setText("request failed")
                }
            )

            rq.add(ogjReq)
        }
        val btnGetAll: Button = findViewById(R.id.btnGetAll)
        btnGetAll.setOnClickListener(){
            val rq: RequestQueue = Volley.newRequestQueue(this)

            val ogjReq: JsonObjectRequest = JsonObjectRequest(
                //default is get method if not mention
                Request.Method.GET,
                "http://demo.onmyfinger.com/home/getAll",
                null,
                Response.Listener {
                        response -> try{
                            var nameList:StringBuffer = StringBuffer()

                            for(i in 0 until response.length() ){
                                val obj:JSONObject = response.getJSONObject(i.toString())
                                nameList.append(obj.getString("name") + "\n")
                            }

                            val tvResult: TextView = findViewById(R.id.tvResult)
                            tvResult.setText(nameList)

                }catch (e:JSONException){
                    val tvResult: TextView = findViewById(R.id.tvResult)
                    tvResult.setText(e.message)
                }
                }, Response.ErrorListener {
                        error -> findViewById<TextView>(R.id.tvResult).setText(error.message)
                    //val tvResult: TextView = findViewById(R.id.tvResult)
                    //tvResult.setText("request failed")
                }
            )

            rq.add(ogjReq)
        }

        val btnAdd: Button = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener(){
            val rq: RequestQueue = Volley.newRequestQueue(this)

            val ogjReq: JsonObjectRequest = JsonObjectRequest(
                //default is get method if not mention
                Request.Method.GET,
                "http://demo.onmyfinger.com/home/Add?id=w777&name=Lee&program=DFT",
                null,
                Response.Listener {
                        response -> try{
                    var nameList:StringBuffer = StringBuffer()

                    for(i in 0 until response.length() ){
                        val obj:JSONObject = response.getJSONObject(i.toString())
                        nameList.append(obj.getString("name") + "\n")
                    }

                    val tvResult: TextView = findViewById(R.id.tvResult)
                    tvResult.setText(nameList)

                }catch (e:JSONException){
                    val tvResult: TextView = findViewById(R.id.tvResult)
                    tvResult.setText(e.message)
                }
                }, Response.ErrorListener {
                        error -> findViewById<TextView>(R.id.tvResult).setText(error.message)

                }
            )

            rq.add(ogjReq)
        }

    }
}