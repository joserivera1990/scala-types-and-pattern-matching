object TestPair {

  val pair = ("JOSE", "RIVERA")

  pair._1
  pair._2
  pair.swap

  val absentGreeting: Option[String] = Option(null)

  val presentGreeting: Option[String] = Option("Hello!")


  case class User(id: Int, firstName: String, lastName: String, age: Int,
                  gender: Option[String])

  object UserRepository { private val users = Map(
    1 -> User(1, "John", "Doe", 32, Some("male")),
    2 -> User(2, "Johanna", "Doe", 30, None))
    def findById(id: Int): Option[User] = users.get(id)
    def findAll = users.values
  }

  val user = User(2, "Johanna", "Doe", 30, None)
  // will print "not specified":
  println("Gender: " + user.gender.getOrElse("not specified"))

  val user1 = User(2, "Johanna", "Doe", 30, None)
  user.gender match {
    case Some(gender) => println(s"Gender: $gender")
    case None => println("Gender: not specified")
  }

  for{
    user <- UserRepository.findById(1)
    gender <- user.gender
  } yield gender

  for{
    User(_, _, _, _, Some(gender)) <- UserRepository.findAll
  } yield gender

  import scala.io.Source
  import java.net.URL
  def getContent(url: URL): Either[String, Source] =
    if (url.getHost.contains("google"))
      Left("Requested URL is blocked for the good of the people!")
    else
      Right(Source.fromURL(url))

  val content: Either[String, Iterator[String]] =
    getContent(new URL("http://danielwestheide.com")).right.map(_.getLines())

  val moreContent: Either[String, Iterator[String]] =
    getContent(new URL("http://google.com")).right.map(_.getLines)

}
