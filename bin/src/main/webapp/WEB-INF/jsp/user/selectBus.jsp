<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<link rel="stylesheet" href="css/searchRoutesstyle.css">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Select Bus</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/2c135d6bdb.js"
	crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
		<div class="row pt-1 pb-1">
			<div class="col-lg-12 text-center">
				<h3 class="py-3">
					<a href="https://dxc.com/"> <img src="images/img.png" alt=""
						class="logo"></a>
				</h3>
				<a href="" class="user"><i class="fa fa-user"></i></a>
               <a href="searchbuspage" class="home"><i class="fa fa-home"></i></a>
				<br>
				<h2 class="text-center">Welcome to Transportation Services</h2>
				<br>
				<h5 class="text-center">Available Buses</h5>
			</div>
		</div>
	</div>
	<section>

		<section class="search-sec">
			<div class="container">
					<div class="col-lg-12">
						<div class="row">
							<table class="table table-striped table-dark">
								<thead>
									<tr>
										<th scope="col">Bus Name</th>
										<th scope="col">Bus Type</th>
										<th scope="col">Origin</th>
										<th scope="col">Destination</th>
										<th scope="col">Travel Date</th>
										<th scope="col">Price</th>
										<th scope="col"></th>
									</tr>

								</thead>
								<tbody>
									<c:forEach items="${bus}" var="bus">
										<tr>
										<td><c:out value="${bus.busName}" /></td>
										<td><c:out value="${bus.busType}" /></td>
										<td><c:out value="${bus.origin}" /></td>
										<td><c:out value="${bus.destination}" /></td>
										<td scope="row"><c:out value="${bus.travelDate}" /></td>
										<td><c:out value="${bus.tktFare}" /></td>
										<td><a href="selectBus/${bus.id}"
											class="btn btn-primary btn-sm active" role="button"
											aria-pressed="true">Select</a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
			</div>
			</div>
		</section>

		</div>
		</div>
		</div>
	</section>


</body>
</html>