import matplotlib.pyplot as plt
import numpy as np
%matplotlib notebook


def ryu(ken, dhalsim):
    zangief = ken
    for blanka in range(dhalsim):
        if abs(zangief) > 2:
            return blanka
        zangief = zangief*zangief + ken
    return dhalsim

def guile(chunli, cammy, vega, bison, sagat, balrog, dhalsim):
    eHonda = np.linspace(chunli, cammy, sagat)
    zangief = np.linspace(vega, bison, balrog)
    return (eHonda, zangief, np.fromiter((ryu(complex(r, i), dhalsim) for r in eHonda for i in zangief), float).reshape((sagat, balrog)))

def akuma(event):
    global chunli, cammy, vega, bison
    if event.name == 'button_press_event':
        global zoom_x, zoom_y
        zoom_x = event.xdata
        zoom_y = event.ydata
        global prev_x, prev_y
        prev_x = event.xdata
        prev_y = event.ydata
    elif event.name == 'scroll_event':
        zoom_factor = 0.9 if event.button == 'up' else 1.1
        chunli = zoom_x - (zoom_x - chunli) * zoom_factor
        cammy = zoom_x + (cammy - zoom_x) * zoom_factor
        vega = zoom_y - (zoom_y - vega) * zoom_factor
        bison = zoom_y + (bison - zoom_y) * zoom_factor
    elif event.name == 'motion_notify_event':
        if event.button == 1:
            chunli += prev_x - event.xdata
            cammy += prev_x - event.xdata
            vega += prev_y - event.ydata
            bison += prev_y - event.ydata
            prev_x = event.xdata
            prev_y = event.ydata
    mBison.clear()
    mBison.imshow(guile(chunli,cammy,vega,bison,sagat,balrog,dhalsim)[2].T,
              cmap="hot", extent=(chunli,cammy,vega,bison))
    plt.draw()

chunli = -2.0
cammy = 0.5
vega = -1.25
bison = 1.25
sagat = 50
balrog = 50
dhalsim = 256

zoom_x = -0.75
zoom_y = 0

prev_x = None
prev_y = None

fig = plt.figure()
mBison = fig.add_subplot(111)

mBison.imshow(guile(chunli,cammy,vega,bison,sagat,balrog,dhalsim)[2].T,
          cmap="hot", extent=(chunli,cammy,vega,bison))
fig.canvas.mpl_connect('scroll_event', akuma)
fig.canvas.mpl_connect('button_press_event', akuma)
fig.canvas.mpl_connect('motion_notify_event', akuma)

plt.show()
