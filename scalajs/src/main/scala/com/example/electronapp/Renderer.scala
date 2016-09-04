package com.example.electronapp

import scala.scalajs.js
import org.scalajs.jquery.{JQueryAjaxSettings, jQuery => $}

import azuaron.electriserver.api.{MyThing, MyThingUpdate}
import js.Dynamic.{global => g}
import js.annotation.JSExport

@JSExport
object Renderer {

  val fs = g.require("fs")

  @JSExport
  def main(): Unit = {
    $("body").append("<p>Hello World from Scala.js</p>")
    val filenames = listFiles(".")
    display(filenames)
  }

  def display(filenames: Seq[String]) = {
    $("body").append("<p>Listing the files in the '.' using node.js API:")
    $("body").append("<ul>")
    filenames.foreach { filename =>
      $("body").append(s"<li>$filename</li>")
    }
    $("body").append("</ul></p>")

    /*$.post(g.literal(
      url = "http://localhost:8080/my-thing",
      data =
      success = {(data: js.Any, textStatus: js.String, errorThrow: js.String) =>

      },
      `type` = "POST"
    ).asInstanceOf[JQueryAjaxSettings])*/
  }

  def listFiles(path: String): Seq[String] = {
    fs.readdirSync(path).asInstanceOf[js.Array[String]]
  }
}
