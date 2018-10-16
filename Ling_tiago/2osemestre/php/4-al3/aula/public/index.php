<?php
use \Psr\Http\Message\ServerRequestInterface as Request;
use \Psr\Http\Message\ResponseInterface as Response;

use \app\controller\ControladorApp;

use \app\model\BoloDAOImplementation as BoloDAO;

require '../vendor/autoload.php';

$app = new \Slim\App;
$app->get('/bolo/{idBolo}', function (Request $request, Response $response, array $args) {
    $controlador = new ControladorApp();
    return $controlador->lerBolo($request, $response, $args);
    return $response;
});



$app->post('/bolo', function (Request $request, Response $response, array $args) {
    
    return $response;
});

$app->get('/hello/{name}', function (Request $request, Response $response, array $args) {
    $name = $args['name'];
    $response->getBody()->write("Hello, $name");

    return $response;
});

$app->run();