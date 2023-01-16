# Ship Locator
The goal of this application is to create a backend application which is capable of detecting
ships that enter or leave the port of Rotterdam.
The application will regularly fetch the actual ship locations from the Teqplay platform, and
check whether the ships are inside or outside a polygon of the port of Rotterdam. Every
change should be captured in a port enter/leave event. The application should have an
endpoint where all the port events can be requested, and optionally an endpoint to fetch all
the ships that are currently in the port of Rotterdam.

## Port of Rotterdam area
The following polygon defines the area of the port of Rotterdam:
[
[4.09365, 51.98509],\
[4.08719, 52.01616],\
[3.98969, 52.0345],\
[3.94652, 51.99088],\
[3.95805, 51.9598],\
[3.98431, 51.91666],\
[4.46901, 51.82003],\
[4.55084, 51.64443],\
[4.629, 51.664],\
[4.69875, 51.83797],\
[4.5382, 51.91703],\
[4.09365, 51.98509]
]