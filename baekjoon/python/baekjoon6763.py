def radar_sign(limit, speed):
    over_the_limit = speed - limit
    if over_the_limit <= 0:
        return "Congratulations, you are within the speed limit!"
    else:
        fine = 0
        if over_the_limit > 0 and over_the_limit <= 20:
            fine = 100
        elif over_the_limit > 20 and over_the_limit <= 30:
            fine = 270
        elif over_the_limit > 30:
            fine = 500
        return f"You are speeding and your fine is ${fine}."

limit = int(input())
speed = int(input())
print(radar_sign(limit, speed))
