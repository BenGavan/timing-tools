import time


def time_period(duration, interval):
	print(f'duration: {duration}')
	print(f'interval: {interval}')

	for i in range(duration // interval):
		print(i)
		time.sleep(interval)

	print("*** End ***\a\a\a")


def run():
	duration = 10  # seconds between each counting/timing period
	interval = 1   # seconds between each indicated increment

	time_period(duration, interval)


def main():
	print("-----------")
	print("Timing tool")
	print("-----------")
	run()


if __name__ == '__main__':
	main()
