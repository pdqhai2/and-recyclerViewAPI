# and-recyclerViewAPI : file api.php trong laravel :

<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

Route::get('newsapi', function() {
    $news = array();
    $xml = simplexml_load_file("https://vnexpress.net/rss/tin-moi-nhat.rss") or die("Feed not loading...");
    foreach ($xml->channel->item as $article) {
        $CDATA = $article->description;
        preg_match('/(?<=<\/br>).*/', $CDATA, $description);
        preg_match('/<img [^>]*src="([^"]+)"/', $CDATA, $img_url);
        array_push($news, array(
            "title" => reset($article->title),
            "pub_day" => reset($article->pubDate),
            "link" => reset($article->link),
        ));
    }
    return response()->json($news);
    // dd($news);
});
